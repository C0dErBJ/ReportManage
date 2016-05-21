package com.reportmanage.controller.student;

import com.reportmanage.controller.base.BaseController;
import com.reportmanage.controller.model.main.publish.MissionModel;
import com.reportmanage.model.*;
import com.reportmanage.service.*;
import com.reportmanage.utils.HtmlConverter;
import com.reportmanage.utils.Word2Html;
import org.apache.commons.io.FileUtils;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.io.File;
import java.util.Date;

/**
 * Created by C0dEr on 16/2/28.
 */
@Controller
@RequestMapping("/student")
public class MissionController extends BaseController {
    @Resource
    private IMissionService missionService;
    @Resource
    private IFileService fileService;
    @Resource
    private ICommitService commitService;
    @Resource
    private IProgressService progressService;
    @Resource
    private ITemplateService templateService;

    @RequestMapping("mission")
    public ModelAndView mission(HttpSession session) {
        ModelAndView view = new ModelAndView("student/mission");
        Mission mission = missionService.selectMissionByClassWithUserid(getCurrentUser(session).getId());
        if (mission != null) {
            view.addObject("title", mission.getTitle());
            view.addObject("des", mission.getDescription());
            view.addObject("filepath", mission.getFileid());
        }
        return view;
    }

    @RequestMapping("reportedit")
    public ModelAndView reportedit(HttpServletRequest request) throws IOException, TransformerException, ParserConfigurationException {
        ModelAndView view = new ModelAndView("student/ReportEdit");
        Template model = templateService.getTemplate();
        if (model != null) {
            String dirpath = request.getSession().getServletContext().getRealPath("/") + "/uploads/change/" + new Date().getTime() + ".html";
            java.io.File path = new File(request.getSession().getServletContext().getRealPath("/") + "/uploads/change/");
            if (!path.exists()) {
                path.mkdir();
            }
            com.reportmanage.model.File f = fileService.getFile(Integer.parseInt(model.getName()));
            if (f != null){
                Word2Html.convert2Html(f.getFilepath(), dirpath);
            }else{
                view.addObject("");
                return view;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(dirpath)));
            StringBuilder sb = new StringBuilder();
            String data = null;
            while ((data = br.readLine()) != null) {
                sb.append(data);
            }
            view.addObject("html", sb.toString());
        } else {
            view.addObject("");
        }
        return view;
    }

    @RequestMapping(value = "content", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> convert(String content, HttpSession session, HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        HtmlConverter hc = new HtmlConverter();
        java.io.File dirpath = new java.io.File(request.getSession().getServletContext().getRealPath("/") + "/uploads/" + "模板" + (new Date().getTime()) + ".docx");
        WordprocessingMLPackage wp = null;
        try {
            wp = hc.html2word(content);
            wp.save(dirpath);
            headers.setContentDispositionFormData("attachment", java.net.URLEncoder.encode("模板", "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.reportmanage.model.File file = new com.reportmanage.model.File();
        file.setFiletype("docx");
        file.setFilepath(dirpath.getAbsolutePath());
        file.setFilename("模板.docx");
        int i = fileService.insertBackPri(file);
        Progress mo = new Progress();
        mo.setMissionid(missionService.selectMissionByClassWithUserid(getCurrentUser(session).getId()).getId());
        mo.setCreatetime(new Date());
        mo.setDescription("模板下载");
        mo.setUserid(getCurrentUser(session).getId());
        progressService.insertProgress(mo);
        return new ResponseEntity<String>(file.getId() + "",
                headers, HttpStatus.CREATED);

    }

    @RequestMapping("commitwork")
    public ModelAndView commitwork() {
        ModelAndView view = new ModelAndView("student/commitwork");
        return view;
    }

    @RequestMapping("mywork")
    public ModelAndView mywork(HttpSession session) {
        ModelAndView view = new ModelAndView("student/mywork");
        Commit model = commitService.getCommit(getCurrentUser(session).getId());
        view.addObject("status", model.getIspass());
        view.addObject("stdes", model.getStudentnote());
        view.addObject("thdes", model.getTeachernote());
        view.addObject("filepath", model.getFileid());
        return view;
    }

    @RequestMapping(value = "commit", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView commit(MissionModel model, HttpSession session, final RedirectAttributes redirectAttributes) {
        Commit commitModel = new Commit();
        commitModel.setCreatetime(new Date());
        commitModel.setFileid(Integer.parseInt(model.getFileid()));
        commitModel.setIspass(0);
        commitModel.setMissionid(missionService.selectMissionByClassWithUserid(getCurrentUser(session).getId()).getId());
        commitModel.setStudentnote(model.getDes());
        commitModel.setUserid(getCurrentUser(session).getId());
        commitService.commit(commitModel);
        Progress mo = new Progress();
        mo.setMissionid(missionService.selectMissionByClassWithUserid(getCurrentUser(session).getId()).getId());
        mo.setCreatetime(new Date());
        mo.setDescription("提交作业");
        mo.setUserid(getCurrentUser(session).getId());
        progressService.insertProgress(mo);
        redirectAttributes.addFlashAttribute("redUrl", "/student/mywork");
        redirectAttributes.addFlashAttribute("status", "Success");
        return new ModelAndView("redirect:/afterSubmit");
    }

}

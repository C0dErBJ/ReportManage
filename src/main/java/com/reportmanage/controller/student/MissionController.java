package com.reportmanage.controller.student;

import com.reportmanage.controller.base.BaseController;
import com.reportmanage.model.Mission;
import com.reportmanage.service.IFileService;
import com.reportmanage.service.IMissionService;
import com.reportmanage.utils.HtmlConverter;
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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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
    public ModelAndView reportedit() {
        ModelAndView view = new ModelAndView("student/ReportEdit");
        return view;
    }

    @RequestMapping(value = "content", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> convert(String content, HttpServletRequest request) {
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
        return new ResponseEntity<String>(file.getId() + "",
                headers, HttpStatus.CREATED);

    }


}

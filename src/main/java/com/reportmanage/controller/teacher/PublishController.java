package com.reportmanage.controller.teacher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.reportmanage.controller.base.BaseController;
import com.reportmanage.controller.model.main.publish.GuideBookModel;
import com.reportmanage.controller.model.main.publish.MissionModel;
import com.reportmanage.controller.model.main.publish.RequireModel;
import com.reportmanage.model.*;
import com.reportmanage.service.*;
import com.reportmanage.utils.Word2Html;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by C0dEr on 16/2/23.
 */
@Controller
public class PublishController extends BaseController {
    @Resource
    private IMissionService missionService;
    @Resource
    private IFileService fileService;
    @Resource
    private ICommitService commitService;
    @Resource
    private IUserService userService;
    @Resource
    private IProgressService progressService;
    @Resource
    private ITemplateService templateService;
    @Resource
    private IRequireService requireServicel;
    @Resource
    private IGuideBookService guideBookService;

    @RequestMapping("publish")
    public String Index() {
        return "/teacher/publish";
    }

    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView publish(MissionModel model, HttpSession session, final RedirectAttributes redirectAttributes) {
        if (model != null) {
            Mission bean = new Mission();
            bean.setDescription(model.getDes());
            bean.setFileid(model.getFileid());
            bean.setTitle(model.getTitle());
            bean.setUserid(getCurrentUser(session).getId());
            bean.setCreatetime(new Date());
            boolean result = missionService.addMission(bean);
            redirectAttributes.addFlashAttribute("redUrl", "/publishlist");
            redirectAttributes.addFlashAttribute("status", "Success");
            return new ModelAndView("redirect:/afterSubmit");
        }
        redirectAttributes.addFlashAttribute("redUrl", "/publishlist");
        redirectAttributes.addFlashAttribute("status", "Fail");
        return new ModelAndView("redirect:/afterSubmit");
    }

    @RequestMapping("publishlist")
    public ModelAndView getlist() {
        ModelAndView view = new ModelAndView("/teacher/publishlist");
        return view;
    }

    @ResponseBody
    @RequestMapping(value = "mypublishlist", method = RequestMethod.GET)
    public Object publiclist(HttpSession session) throws JsonProcessingException {
        List<Mission> missions = missionService.getMissionbyUser(getCurrentUser(session).getId());
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        root.put("draw", missions.size());
        root.put("recordsTotal", missions.size());
        root.put("recordsFiltered", missions.size());
        ArrayNode an = root.arrayNode();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Mission item : missions) {
            missionModel model = new missionModel();
            model.date = sdf.format(item.getCreatetime());
            model.des = item.getDescription();
            model.title = item.getTitle();
            model.url = "<a href='/file/" + item.getFileid() + "' class='btn btn-primary'>下载</a>";
            model.detail = "<a href='/missionlist/" + item.getId() + "' class='btn btn-primary'>查看</a>";
            an.addPOJO(model);
        }
        root.putArray("data").addAll(an);
        return root;
    }


    @RequestMapping(value = "commitdetail/{i}")
    public ModelAndView CommitDetail(@PathVariable int i) {
        ModelAndView view = new ModelAndView("/teacher/commitdetail");
        Commit commit = commitService.getCommitById(i);
        view.addObject("status", commit.getIspass());
        view.addObject("stdes", commit.getStudentnote());
        view.addObject("thdes", commit.getTeachernote());
        view.addObject("filepath", commit.getFileid());
        view.addObject("commitid", commit.getUserid());
        return view;
    }

    @RequestMapping(value = "commitnote", method = RequestMethod.POST)

    @ResponseBody
    public ModelAndView commit(MissionModel model, HttpSession session, final RedirectAttributes redirectAttributes) {
        Commit commit = commitService.getCommit(model.getId());
        if (commit == null) {
            redirectAttributes.addFlashAttribute("redUrl", "/publishlist");
            redirectAttributes.addFlashAttribute("status", "Fail");
            return new ModelAndView("redirect:/afterSubmit");
        }
        commit.setTeachernote(model.getDes());
        commit.setIspass(model.getTitle().equals("已通过") ? 1 : 0);
        commitService.update(commit);
        if (model.getTitle().equals("已通过")) {
            Progress progress = new Progress();
            progress.setUserid(commit.getUserid());
            progress.setCreatetime(new Date());
            progress.setDescription("审阅通过");
            progress.setMissionid(commit.getMissionid());
            progressService.insertProgress(progress);
        }
        redirectAttributes.addFlashAttribute("redUrl", "/publishlist");
        redirectAttributes.addFlashAttribute("status", "Success");
        return new ModelAndView("redirect:/afterSubmit");
    }

    @ResponseBody
    @RequestMapping(value = "detail/{i}", method = RequestMethod.GET)
    public Object detail(@PathVariable int i) {
        List<Commit> list = commitService.getCommits(i);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        root.put("draw", list.size());
        root.put("recordsTotal", list.size());
        root.put("recordsFiltered", list.size());
        ArrayNode an = root.arrayNode();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Commit item : list) {
            missionModel model = new missionModel();
            model.des = item.getIspass() > 0 ? "完成" : "未完成";
            model.title = userService.getUser(item.getUserid()).getName();
            model.url = "<a href='/commitdetail/" + item.getId() + "' class='btn btn-primary'>查看</a>";
            an.addPOJO(model);
        }
        root.putArray("data").addAll(an);
        return root;
    }

    @RequestMapping(value = "missionlist/{i}", method = RequestMethod.GET)
    public ModelAndView missionlist(@PathVariable int i) {
        ModelAndView view = new ModelAndView("/teacher/missonList");
        view.addObject("id", i);
        return view;
    }

    private class missionModel {
        public String date;
        public String title;
        public String des;
        public String url;
        public String detail;
    }

    @RequestMapping("template")
    public ModelAndView template() {
        ModelAndView view = new ModelAndView("/teacher/mubanshangchuan");
        return view;
    }

    @RequestMapping(value = "template", method = RequestMethod.POST)
    public ModelAndView settemplate(String fileid, final RedirectAttributes redirectAttributes) {
        Template model = new Template();
        model.setName(fileid);
        templateService.addTemplate(model);
        redirectAttributes.addFlashAttribute("redUrl", "/template");
        redirectAttributes.addFlashAttribute("status", "Success");
        return new ModelAndView("redirect:/afterSubmit");

    }

    @RequestMapping("templatechakan")
    public ModelAndView templatechakan(HttpServletRequest request) throws ParserConfigurationException, TransformerException, IOException {
        ModelAndView view = new ModelAndView("/teacher/mubanchakan");
        Template model = templateService.getTemplate();
        if (model != null) {
            String dirpath = request.getSession().getServletContext().getRealPath("/") + "/uploads/change/" + new Date().getTime() + ".html";
            java.io.File path = new File(request.getSession().getServletContext().getRealPath("/") + "/uploads/change/");
            if (!path.exists()) {
                path.mkdir();
            }
            com.reportmanage.model.File f = fileService.getFile(Integer.parseInt(model.getName()));
            if (f != null) {
                Word2Html.convert2Html(f.getFilepath(), dirpath);
            } else {
                view.addObject("");
                return view;
            }
            Word2Html.convert2Html(fileService.getFile(Integer.parseInt(model.getName())).getFilepath(), dirpath);

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

    @RequestMapping("require")
    public String requireIndex() {
        return "/teacher/require";
    }

    @RequestMapping(value = "require", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView requirepublish(RequireModel model, HttpSession session, final RedirectAttributes redirectAttributes) {
        if (model != null) {
            Require bean = new Require();
            bean.setDescription(model.getDes());
            bean.setFileid(model.getFileid());
            bean.setTitle(model.getTitle());
            bean.setUserid(getCurrentUser(session).getId());
            bean.setCreatetime(new Date());
            boolean result = requireServicel.addRequire(bean);
            redirectAttributes.addFlashAttribute("redUrl", "/publishlist");
            redirectAttributes.addFlashAttribute("status", "Success");
            return new ModelAndView("redirect:/afterSubmit");
        }
        redirectAttributes.addFlashAttribute("redUrl", "/publishlist");
        redirectAttributes.addFlashAttribute("status", "Fail");
        return new ModelAndView("redirect:/afterSubmit");
    }

    @RequestMapping("guidebook")
    public String guidebookIndex() {
        return "/teacher/guidebook";
    }

    @RequestMapping(value = "guidebook", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView guidebookpublish(GuideBookModel model, HttpSession session, final RedirectAttributes redirectAttributes) {
        if (model != null) {
            Guidebook bean = new Guidebook();
            bean.setDescription(model.getDes());
            bean.setFileid(model.getFileid());
            bean.setTitle(model.getTitle());
            bean.setUserid(getCurrentUser(session).getId());
            bean.setCreatetime(new Date());
            boolean result = guideBookService.addGuideBook(bean);
            redirectAttributes.addFlashAttribute("redUrl", "/welcome");
            redirectAttributes.addFlashAttribute("status", "Success");
            return new ModelAndView("redirect:/afterSubmit");
        }
        redirectAttributes.addFlashAttribute("redUrl", "/welcome");
        redirectAttributes.addFlashAttribute("status", "Fail");
        return new ModelAndView("redirect:/afterSubmit");
    }
}

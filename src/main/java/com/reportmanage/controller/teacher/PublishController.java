package com.reportmanage.controller.teacher;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.reportmanage.controller.base.BaseController;
import com.reportmanage.controller.model.main.publish.MissionModel;
import com.reportmanage.dao.MissionMapper;
import com.reportmanage.model.File;
import com.reportmanage.model.Mission;
import com.reportmanage.service.IFileService;
import com.reportmanage.service.IMissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

    @RequestMapping("publish")
    public String Index() {
        return "/teacher/publish";
    }

    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView publish(MissionModel model, HttpSession session) {
        if (model != null) {
            Mission bean = new Mission();
            bean.setDescription(model.getDes());
            bean.setFileid(model.getFileid());
            bean.setTitle(model.getTitle());
            bean.setUserid(getCurrentUser(session).getId());
            bean.setCreatetime(new Date());
            boolean result = missionService.addMission(bean);
            RedirectAttributes map = new RedirectAttributesModelMap();
            map.addAttribute("redUrl", "/teacher/publish");
            map.addAttribute("status", "Success");
            return new ModelAndView("handlerresult");
        }
        RedirectAttributes map = new RedirectAttributesModelMap();
        map.addAttribute("redUrl", "/teacher/publish");
        map.addAttribute("status", "Fail");
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
            an.addPOJO(model);
        }
        root.putArray("data").addAll(an);
        return root;
    }

    private class missionModel {
        public String date;
        public String title;
        public String des;
        public String url;
    }
}

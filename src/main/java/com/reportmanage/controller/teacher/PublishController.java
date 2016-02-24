package com.reportmanage.controller.teacher;

import com.reportmanage.controller.base.BaseController;
import com.reportmanage.controller.model.main.publish.MissionModel;
import com.reportmanage.dao.MissionMapper;
import com.reportmanage.model.Mission;
import com.reportmanage.service.IMissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by C0dEr on 16/2/23.
 */
@Controller
public class PublishController extends BaseController {
    @Resource
    private IMissionService missionService;

    @RequestMapping("publish")
    public String Index() {
        return "/teacher/publish";
    }

    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ResponseBody
    public String publish(MissionModel model) {
        if (model != null) {
            Mission bean = new Mission();
            bean.setDescription(model.getDes());
            bean.setFileid(model.getFileid());
            bean.setTitle(model.getTitle());
            boolean result = missionService.addMission(bean);
            return "Success";
        }
        return "False";
    }
}

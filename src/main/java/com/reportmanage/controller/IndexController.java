package com.reportmanage.controller;

import com.reportmanage.controller.base.BaseController;
import com.reportmanage.controller.model.login.LoginModel;
import com.reportmanage.model.User;
import com.reportmanage.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by C0dEr on 16/2/23.
 */
@Controller
public class IndexController extends BaseController {
    @Resource
    private IUserService userService;

    @RequestMapping("/")
    public ModelAndView Index(HttpSession session) {
        if (getCurrentUser(session) != null) {
            return new ModelAndView("redirect:main");
        }
        ModelAndView view = new ModelAndView("login");
        view.addObject("systemname", "学生");
        return view;
    }

    @RequestMapping(value = "loginstu", method = {RequestMethod.GET})
    public ModelAndView StuIndex() {
        ModelAndView view = new ModelAndView("login");
        view.addObject("systemname", "学生");
        return view;
    }

    @RequestMapping(value = "loginth", method = {RequestMethod.GET})
    public ModelAndView ThIndex() {
        ModelAndView view = new ModelAndView("login");
        view.addObject("systemname", "教师");
        return view;
    }

    @RequestMapping(value = "login", method = {RequestMethod.POST})
    public String Login(LoginModel model, HttpSession session) {
        if (model != null) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("username", model.getUsername());
            map.put("password", model.getPassword());
            map.put("role", model.getLogintype());
            User mUser = userService.getUser(map);
            if (mUser != null) {
                setCurrentUser(mUser);
                session.setAttribute("user", mUser);
                return "redirect:main";
            }
        }
        if (model.getLogintype().equals("学生")) {
            return "redirect:/loginstu";
        } else {
            return "redirect:/loginth";
        }
    }
}

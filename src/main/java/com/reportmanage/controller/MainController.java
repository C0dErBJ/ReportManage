package com.reportmanage.controller;

import com.reportmanage.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by C0dEr on 16/2/23.
 */
@Controller
public class MainController extends BaseController{

    @RequestMapping("main")
    public ModelAndView Index() {
        ModelAndView view=new ModelAndView("main");
        if(CurrentUser!=null){
            view.addObject("name",CurrentUser.getName());
        }
        return view;
    }

    @RequestMapping("welcome")
    public String WelcomeIndex() {
        return "welcome";
    }
}

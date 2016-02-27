package com.reportmanage.controller;

import com.reportmanage.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by C0dEr on 16/2/23.
 */
@Controller
public class MainController extends BaseController {

    @RequestMapping("main")
    public ModelAndView Index(HttpSession session) {
        ModelAndView view = new ModelAndView("main");
        if (getCurrentUser(session) != null) {
            view.addObject("name", getCurrentUser(session).getName());
            view.addObject("role", getCurrentUser(session).getRole());
        }
        return view;
    }

    @RequestMapping("welcome")
    public String WelcomeIndex() {
        return "welcome";
    }

    @RequestMapping("afterSubmit")
    public ModelAndView Success(@PathVariable String redUrl,@PathVariable String status){
        ModelAndView view=new ModelAndView("handleresult");
        view.addObject("reUrl",redUrl);
        if(status.equals("Success")){
            view.addObject("statusWord","操作成功!!");
        }else{
            view.addObject("statusWord","操作失败!!");
        }

        return view;
    }
}

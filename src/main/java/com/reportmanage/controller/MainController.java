package com.reportmanage.controller;

import com.reportmanage.controller.base.BaseController;
import com.reportmanage.model.Progress;
import com.reportmanage.service.IProgressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by C0dEr on 16/2/23.
 */
@Controller
public class MainController extends BaseController {
@Resource
private IProgressService progressService;
    @RequestMapping("main")
    public ModelAndView Index(HttpSession session) {
        ModelAndView view = new ModelAndView("main");
        if (getCurrentUser(session) != null) {
            view.addObject("name", getCurrentUser(session).getName());
            view.addObject("role", getCurrentUser(session).getRole());
        }else{
            view.addObject("red", "/loginstu");
        }
        return view;
    }

    @RequestMapping("welcome")
    public ModelAndView WelcomeIndex(HttpSession session) {
        ModelAndView view = new ModelAndView("welcome");
        List<Progress> list=progressService.getProgress(getCurrentUser(session).getId());
        if(list!=null&&list.size()>0){
            view.addObject("progress", ((float)list.size()/3)*100);
        }else{
            view.addObject("progress", 0);
        }
        if (getCurrentUser(session) != null) {
            view.addObject("role", getCurrentUser(session).getRole());
        }
        return view;
    }

    @RequestMapping("afterSubmit")
    public ModelAndView Success(@ModelAttribute("redUrl")String redUrl,@ModelAttribute("status") String status){
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

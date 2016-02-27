package com.reportmanage.controller.base;

import com.reportmanage.model.User;

import javax.servlet.http.HttpSession;

/**
 * Created by C0dEr on 16/2/23.
 */
public class BaseController {
    public User getCurrentUser(HttpSession session) {
        Object user = session.getAttribute("user");
        if (user != null) {
            CurrentUser = (User) user;
        }
        return CurrentUser;
    }

    public void setCurrentUser(User currentUser) {
        CurrentUser = currentUser;
    }

    private User CurrentUser;
}

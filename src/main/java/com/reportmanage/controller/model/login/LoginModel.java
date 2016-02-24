package com.reportmanage.controller.model.login;

/**
 * Created by C0dEr on 16/2/23.
 */
public class LoginModel {
    private String username;
    private String password;
    private String logintype;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }
}

package com.reportmanage.controller.model.main.publish;

/**
 * Created by C0dEr on 16/2/24.
 */
public class MissionModel {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

    private String title;
    private String des;
    private String fileid;
}

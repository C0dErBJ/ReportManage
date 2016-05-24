package com.reportmanage.controller.model.main.publish;

/**
 * Created by C0dEr on 16/2/24.
 */
public class RequireModel {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int id;
    private String title;
    private String des;
    private String fileid;
}

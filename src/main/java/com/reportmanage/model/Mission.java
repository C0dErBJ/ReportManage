package com.reportmanage.model;

import java.util.Date;

public class Mission {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Mission.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Mission.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Mission.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Mission.fileId
     *
     * @mbggenerated
     */
    private String fileid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Mission.userid
     *
     * @mbggenerated
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Mission.CreateTime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Mission.id
     *
     * @return the value of Mission.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Mission.id
     *
     * @param id the value for Mission.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Mission.title
     *
     * @return the value of Mission.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Mission.title
     *
     * @param title the value for Mission.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Mission.description
     *
     * @return the value of Mission.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Mission.description
     *
     * @param description the value for Mission.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Mission.fileId
     *
     * @return the value of Mission.fileId
     *
     * @mbggenerated
     */
    public String getFileid() {
        return fileid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Mission.fileId
     *
     * @param fileid the value for Mission.fileId
     *
     * @mbggenerated
     */
    public void setFileid(String fileid) {
        this.fileid = fileid == null ? null : fileid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Mission.userid
     *
     * @return the value of Mission.userid
     *
     * @mbggenerated
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Mission.userid
     *
     * @param userid the value for Mission.userid
     *
     * @mbggenerated
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Mission.CreateTime
     *
     * @return the value of Mission.CreateTime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Mission.CreateTime
     *
     * @param createtime the value for Mission.CreateTime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
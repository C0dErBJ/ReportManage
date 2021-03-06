package com.reportmanage.model;

import java.util.Date;

public class Commit {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Commit.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Commit.createtime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Commit.missionid
     *
     * @mbggenerated
     */
    private Integer missionid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Commit.fileid
     *
     * @mbggenerated
     */
    private Integer fileid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Commit.studentnote
     *
     * @mbggenerated
     */
    private String studentnote;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Commit.teachernote
     *
     * @mbggenerated
     */
    private String teachernote;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Commit.isPass
     *
     * @mbggenerated
     */
    private Integer ispass;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Commit.UserId
     *
     * @mbggenerated
     */
    private Integer userid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Commit.id
     *
     * @return the value of Commit.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Commit.id
     *
     * @param id the value for Commit.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Commit.createtime
     *
     * @return the value of Commit.createtime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Commit.createtime
     *
     * @param createtime the value for Commit.createtime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Commit.missionid
     *
     * @return the value of Commit.missionid
     *
     * @mbggenerated
     */
    public Integer getMissionid() {
        return missionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Commit.missionid
     *
     * @param missionid the value for Commit.missionid
     *
     * @mbggenerated
     */
    public void setMissionid(Integer missionid) {
        this.missionid = missionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Commit.fileid
     *
     * @return the value of Commit.fileid
     *
     * @mbggenerated
     */
    public Integer getFileid() {
        return fileid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Commit.fileid
     *
     * @param fileid the value for Commit.fileid
     *
     * @mbggenerated
     */
    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Commit.studentnote
     *
     * @return the value of Commit.studentnote
     *
     * @mbggenerated
     */
    public String getStudentnote() {
        return studentnote;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Commit.studentnote
     *
     * @param studentnote the value for Commit.studentnote
     *
     * @mbggenerated
     */
    public void setStudentnote(String studentnote) {
        this.studentnote = studentnote == null ? null : studentnote.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Commit.teachernote
     *
     * @return the value of Commit.teachernote
     *
     * @mbggenerated
     */
    public String getTeachernote() {
        return teachernote;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Commit.teachernote
     *
     * @param teachernote the value for Commit.teachernote
     *
     * @mbggenerated
     */
    public void setTeachernote(String teachernote) {
        this.teachernote = teachernote == null ? null : teachernote.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Commit.isPass
     *
     * @return the value of Commit.isPass
     *
     * @mbggenerated
     */
    public Integer getIspass() {
        return ispass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Commit.isPass
     *
     * @param ispass the value for Commit.isPass
     *
     * @mbggenerated
     */
    public void setIspass(Integer ispass) {
        this.ispass = ispass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Commit.UserId
     *
     * @return the value of Commit.UserId
     *
     * @mbggenerated
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Commit.UserId
     *
     * @param userid the value for Commit.UserId
     *
     * @mbggenerated
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
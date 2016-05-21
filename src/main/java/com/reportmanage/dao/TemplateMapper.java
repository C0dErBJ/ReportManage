package com.reportmanage.dao;

import com.reportmanage.model.Template;

import java.util.List;

public interface TemplateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Template
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Template
     *
     * @mbggenerated
     */
    int insert(Template record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Template
     *
     * @mbggenerated
     */
    int insertSelective(Template record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Template
     *
     * @mbggenerated
     */
    Template selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Template
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Template record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Template
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Template record);

    List<Template> selectAll();
    void delete();
}
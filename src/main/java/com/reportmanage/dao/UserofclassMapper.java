package com.reportmanage.dao;

import com.reportmanage.model.Userofclass;

public interface UserofclassMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UserOfClass
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UserOfClass
     *
     * @mbggenerated
     */
    int insert(Userofclass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UserOfClass
     *
     * @mbggenerated
     */
    int insertSelective(Userofclass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UserOfClass
     *
     * @mbggenerated
     */
    Userofclass selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UserOfClass
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Userofclass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UserOfClass
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Userofclass record);
}
package com.reportmanage.dao;

import com.reportmanage.model.Mission;

import java.util.List;

public interface MissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Mission
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Mission
     *
     * @mbggenerated
     */
    int insert(Mission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Mission
     *
     * @mbggenerated
     */
    int insertSelective(Mission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Mission
     *
     * @mbggenerated
     */
    Mission selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Mission
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Mission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Mission
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Mission record);

    List<Mission> selectByUserId(int i);
}
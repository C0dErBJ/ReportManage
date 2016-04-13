package com.reportmanage.service;

import com.reportmanage.model.Mission;

import java.util.List;

/**
 * Created by C0dEr on 16/2/24.
 */
public interface IMissionService {
    boolean addMission(Mission model);

    List<Mission> getMissionbyUser(int i);

    Mission selectMissionByClassWithUserid(int userid);
}

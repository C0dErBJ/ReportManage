package com.reportmanage.service.Impl;

import com.reportmanage.dao.MissionMapper;
import com.reportmanage.model.Mission;
import com.reportmanage.service.IMissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by C0dEr on 16/2/24.
 */
@Service("missionService")
public class MissonImpl implements IMissionService {
    @Resource
    private MissionMapper missionMapper;

    public boolean addMission(Mission model) {
        return this.missionMapper.insert(model) >= 1;
    }

    public List<Mission> getMissionbyUser(int i) {
        return this.missionMapper.selectByUserId(i);
    }

    public Mission selectMissionByClassWithUserid(int userid) {
       return missionMapper.selectByUserIdThoughtClass(userid);
    }
}

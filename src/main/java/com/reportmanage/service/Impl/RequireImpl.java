package com.reportmanage.service.Impl;

import com.reportmanage.dao.MissionMapper;
import com.reportmanage.dao.RequireMapper;
import com.reportmanage.model.Mission;
import com.reportmanage.model.Require;
import com.reportmanage.service.IMissionService;
import com.reportmanage.service.IRequireService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by C0dEr on 16/2/24.
 */
@Service("requireService")
public class RequireImpl implements IRequireService {
    @Resource
    private RequireMapper requireMapper;

    public boolean addRequire(Require model) {
        return this.requireMapper.insert(model) >= 1;
    }

    public List<Require> getRequirebyUser(int i) {
        return this.requireMapper.selectByUserId(i);
    }

    public Require selectRequireByClassWithUserid(int userid) {
       return requireMapper.selectByUserIdThoughtClass(userid);
    }


}

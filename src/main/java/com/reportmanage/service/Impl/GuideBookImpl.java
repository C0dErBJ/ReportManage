package com.reportmanage.service.Impl;

import com.reportmanage.dao.GuidebookMapper;
import com.reportmanage.dao.MissionMapper;
import com.reportmanage.model.Guidebook;
import com.reportmanage.model.Mission;
import com.reportmanage.service.IGuideBookService;
import com.reportmanage.service.IMissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by C0dEr on 16/2/24.
 */
@Service("guidebookService")
public class GuideBookImpl implements IGuideBookService {
    @Resource
    private GuidebookMapper guidebookMapper;

    public boolean addGuideBook(Guidebook model) {
        return this.guidebookMapper.insert(model) >= 1;
    }

    public List<Guidebook> getGuideBookbyUser(int i) {
        return this.guidebookMapper.selectByUserId(i);
    }

    public Guidebook selectGuideBookByClassWithUserid(int userid) {
       return guidebookMapper.selectByUserIdThoughtClass(userid);
    }


}

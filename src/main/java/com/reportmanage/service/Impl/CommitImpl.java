package com.reportmanage.service.Impl;

import com.reportmanage.dao.CommitMapper;
import com.reportmanage.dao.MissionMapper;
import com.reportmanage.model.Commit;
import com.reportmanage.service.ICommitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by C0dEr on 16/4/14.
 */
@Service("commitService")
public class CommitImpl implements ICommitService {
    @Resource
    private CommitMapper commitMapper;

    public boolean commit(Commit commit) {
        return commitMapper.insert(commit) > 0;
    }

    public Commit getCommit(int id) {
        return commitMapper.selectByUserId(id);
    }

    public List<Commit> getCommits(int id) {
        return commitMapper.selectByMissionId(id);
    }

    public boolean update(Commit commit) {
        return commitMapper.updateByPrimaryKey(commit) > 0;
    }
}

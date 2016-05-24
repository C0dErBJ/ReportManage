package com.reportmanage.service.Impl;

import com.reportmanage.dao.ProgressMapper;
import com.reportmanage.model.Progress;
import com.reportmanage.service.IProgressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by C0dEr on 16/4/14.
 */
@Service("progressService")
public class ProgressImpl implements IProgressService {
    @Resource
    private ProgressMapper mapper;

    public List<Progress> getProgress(int i) {
        return mapper.selectByUserid(i);
    }

    public boolean insertProgress(Progress model) {
        return mapper.insert(model) > 0;
    }

    public List<Progress> getAll() {
        return mapper.selectAll();
    }
}

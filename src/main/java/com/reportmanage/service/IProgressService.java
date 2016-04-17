package com.reportmanage.service;

import com.reportmanage.model.Progress;

import java.util.List;

/**
 * Created by C0dEr on 16/4/14.
 */
public interface IProgressService {
    List<Progress> getProgress(int i);

    boolean insertProgress(Progress model);
}

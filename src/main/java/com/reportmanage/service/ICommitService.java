package com.reportmanage.service;

import com.reportmanage.model.Commit;

import java.util.List;

/**
 * Created by C0dEr on 16/4/14.
 */
public interface ICommitService {

    boolean commit(Commit commit);

    Commit getCommit(int id);

    List<Commit> getCommits(int id);

    boolean update(Commit commit);
}

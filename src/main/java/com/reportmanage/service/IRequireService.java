package com.reportmanage.service;

import com.reportmanage.model.Mission;
import com.reportmanage.model.Require;

import java.util.List;

/**
 * Created by C0dEr on 16/2/24.
 */
public interface IRequireService {
    boolean addRequire(Require model);

    List<Require> getRequirebyUser(int i);

    Require selectRequireByClassWithUserid(int userid);
}

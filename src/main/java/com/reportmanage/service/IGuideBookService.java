package com.reportmanage.service;

import com.reportmanage.model.Guidebook;
import com.reportmanage.model.Mission;

import java.util.List;

/**
 * Created by C0dEr on 16/2/24.
 */
public interface IGuideBookService {
    boolean addGuideBook(Guidebook model);

    List<Guidebook> getGuideBookbyUser(int i);

    Guidebook selectGuideBookByClassWithUserid(int userid);
}

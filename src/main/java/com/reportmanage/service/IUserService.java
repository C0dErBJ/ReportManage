package com.reportmanage.service;

import com.reportmanage.model.User;
import com.reportmanage.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by C0dEr on 16/2/23.
 */
public interface IUserService {
    User getUser(int id);

    User getUser(Map map);

}

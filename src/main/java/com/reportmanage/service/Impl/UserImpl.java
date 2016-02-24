package com.reportmanage.service.Impl;

import com.reportmanage.dao.UserMapper;
import com.reportmanage.model.User;
import com.reportmanage.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by C0dEr on 16/2/23.
 */
@Service("userService")
public class UserImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    public User getUser(int id) {
        return this.userMapper.selectByPrimaryKey(id);
    }


    public User getUser(Map map ) {
        return this.userMapper.selectByUsernameAndPasswordAndRole(map);
    }
}

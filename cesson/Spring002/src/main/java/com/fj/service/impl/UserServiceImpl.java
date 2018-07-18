package com.fj.service.impl;

import com.fj.dao.UserDao;
import com.fj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("s2")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void getUserInfo() {
        userDao.getUser();
    }
}

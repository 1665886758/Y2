package com.fj.dao.impl;

import com.fj.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void getUser() {
        System.out.println("真香。。。");
    }
}

package com.fj.controller;

import com.fj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * 控制层
 */
@Controller("userController")
public class UserController {

    @Autowired     //根据类型查找相应的类
    @Qualifier("s2")    //包含一个以上的相同类型类，使用Qualifier查找制定名称
    public UserService userService;

    public void getInfo(){
        userService.getUserInfo();
    }

}

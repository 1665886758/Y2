package com.fj.controller;

import com.fj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 控制层
 */
@Controller("userController")
public class UserController {

    //@Autowired     //根据类型查找相应的类
   // @Qualifier("s2")    //包含一个以上的相同类型类，使用Qualifier查找指定名称
    @Resource(name = "S2")  // @Resource 等同于Autowired与Qualifier的合体，可以根据类型查找类,并且根据名称查找方法
    public UserService userService;

    public void getInfo(){
        userService.getUserInfo();
    }

}

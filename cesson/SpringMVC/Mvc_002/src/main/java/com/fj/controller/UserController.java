package com.fj.controller;

import com.fj.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/f1")
    @ResponseBody
    public String f1() {
        System.out.println("==============");
        return "you high ";
    }

    @RequestMapping("/m1")
    @ResponseBody       //返回响应消息
    public User m1(){
        User u=new User();
        u.setName("陈诚");
        u.setAddress("北京市朝阳区");
        return u;
    }

    @RequestMapping("/m2")
    @ResponseBody
    public List<User> m2(){
        User u=new User();
        u.setName("张学友");
        u.setAddress("深圳福田");
        List<User> list=new ArrayList<User>();
        list.add(u);
        return list;
    }

    @RequestMapping("/m3")
    @ResponseBody
    public User[] m3(){
        User u=new User();
        u.setName("杨幂");
        u.setAddress("浙江");

        User u2=new User();
        u2.setName("范冰冰");
        u2.setAddress("上海");
        User[] users={u,u2};
        return users;
    }

    @RequestMapping("/m5")
    @ResponseBody
    public Map<String,User> m5(){
//        List<User> l = new ArrayList<>();
        User u  =  new User();
        u.setAddress("振华路");
        u.setName("郭靖");

        User u2  =  new User();
        u2.setAddress("11号");
        u2.setName("杨幂");

        Map<String,User> users = new HashMap<>();
        users.put("u1",u);
        users.put("u2",u2);
        return users;
    }
}

package com.fj.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/xml")
public class  XmlController {

    @RequestMapping("/m1")
    public String demo1(){
        System.out.println("我是MVC啦啦啦");
        return "m1";
    }

    @GetMapping("/m3")
    public String demo3(){
        System.out.println("gggggggeeeeetttttt");
        return "m1";
    }

    //转发
    @RequestMapping("/forward")
    public String forward(){
        System.out.println("转发到m3,地址栏不会发生变化哦哦哦");
        return "m3";
    }

    //重定向
    @RequestMapping("/sendredirect")
    public String sendredirect(){
        System.out.println("重定向到m3,地址栏会发生变化哦");
        return "redirect:/jsp/m3.jsp";
    }

    @RequestMapping(value = "/person/{id}/delete",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void deleteById(@PathVariable(value = "id",required = false) String id){
        System.out.println("成功删除id为"+id+"的用户信息！");
    }
}

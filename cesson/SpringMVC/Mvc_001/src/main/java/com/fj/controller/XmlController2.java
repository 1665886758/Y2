package com.fj.controller;

import com.fj.pojo.Person;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class XmlController2 implements Controller {


    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("m2");
        Person p=new Person();
        p.setName("王菲");
        p.setAddress("梧桐村");
        mav.addObject("m2",p);  //类似于setattrbute
        return mav;
    }

    @RequestMapping("/model2")
    public String model(String personName, Model model){
        model.addAttribute("personName",personName);
        System.out.println("aaaaaaa");
            return "m2";
    }
}

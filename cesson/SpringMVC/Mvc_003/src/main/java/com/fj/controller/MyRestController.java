package com.fj.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MyRestController {

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")String id){
        System.out.println("delete is id:"+id);
        return "nihao mister";
    }

}

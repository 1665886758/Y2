package com.fj.controller;

import com.fj.pojo.Product;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController  // Controller + ResponseBody
@RequestMapping("/product")
public class ProductController {

    @RequestMapping(value = "/add",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String,Object> add(HttpServletRequest request){
        //使用request获取输入信息
        String name=request.getParameter("name");
        String price=request.getParameter("price");
        Double price_=Double.valueOf(price);    //将字符串转换为Double类型
        String createDate=request.getParameter("createDate");
        System.out.println(name+"\t"+price_+"\t"+"\t"+createDate);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("msg","添加成功！");
        return map;
    }

    @RequestMapping("/add2")
    public Map<String,Object> add2(@RequestParam("name") String name,@RequestParam("price") Double price){
        System.out.println(name+price);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("msg","添加成功！");
        return map;
    }

    @RequestMapping("/add3")
    public Map<String,Object> add3(Product product){
        System.out.println(product);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("msg","添加成功！");
        return map;
    }

    @RequestMapping("/add4")
    public Map<String,Object> add4(@RequestBody Product product){
        System.out.println(product+"===aaa");
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("msg","添加成功！");
        return map;
    }

    @RequestMapping("/add5")
    public Map<String,Object> add5(@RequestBody List<Product> products ){
        System.out.println(products+"===bbb");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("msg","添加成功！");
        return map;
    }
}

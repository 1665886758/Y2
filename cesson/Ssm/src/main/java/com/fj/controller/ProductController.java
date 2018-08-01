package com.fj.controller;

import com.fj.pojo.Product;
import com.fj.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/add/{name}/{price}")
    @ResponseBody
    public String controllerAdd(@PathVariable("name") String name,@PathVariable("price") double price){
        Product product=new Product(name,price);
        int row=productService.getAdd(product);
        return row == 1 ? "添加成功！":"添加失败！";
    }

    //product/proInfo/1/5
    @RequestMapping("/proInfo/{pageNo}/{pageSize}")
    public String controllerProductInfo(@PathVariable("pageNo")Integer pageNo,
                                        @PathVariable("pageSize") Integer pageSize, Model model){
        PageInfo<Product> pageInfo= productService.getproductInfo(pageNo,pageSize);
        model.addAttribute("page",pageInfo);
        return "/info";
    }
 }

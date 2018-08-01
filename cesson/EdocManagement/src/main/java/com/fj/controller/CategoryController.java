package com.fj.controller;

import com.fj.pojo.Category;
import com.fj.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/selected")
    public String selected(Model model){
        List<Category> categories= categoryService.getFileCategoryInfo();
        model.addAttribute("categories",categories);
        return "showInfo";
    }
}

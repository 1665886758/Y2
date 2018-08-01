package com.fj.controller;

import com.fj.pojo.Category;
import com.fj.pojo.Entry;
import com.fj.service.CategoryService;
import com.fj.service.EntryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private EntryService entryService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 项目启动默认执行该方法
     */
    @RequestMapping("/")
    public String filesInfo(Model model){
        PageInfo<Entry> page=entryService.getEntryFileInfo();
        model.addAttribute("page",page);

        List<Category> categories= categoryService.getFileCategoryInfo();
        model.addAttribute("categories",categories);

        return "index";
    }
}

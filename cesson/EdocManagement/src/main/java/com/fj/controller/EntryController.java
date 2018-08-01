package com.fj.controller;

import com.fj.pojo.Category;
import com.fj.pojo.Entry;
import com.fj.service.CategoryService;
import com.fj.service.EntryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/filesInfo/{pageNum}/{categoryId}")
    public String filesInfo(@PathVariable("pageNum") Integer pageNum,@PathVariable("categoryId") Integer categoryId,Model model){
        //筛选分类类型
        PageInfo<Entry> page=entryService.listWithPage(pageNum,categoryId);
        model.addAttribute("page",page);

        //绑定下拉框信息
        List<Category> categories= categoryService.getFileCategoryInfo();
        model.addAttribute("categories",categories);

        //存储分类categoryId,(使下拉框不会发生变化)
        model.addAttribute("categoryId",categoryId);
        return "index";
    }

    @RequestMapping("/delFiles/{id}")
    @ResponseBody
    public Map<String,Object> delFilesController(@PathVariable("id") Integer id){
        int row=entryService.deleteFilesInfo(id);
        Map<String,Object> map=new HashMap<String,Object>();
        if(row==1){
            map.put("msg","删除成功！");
        }else{
            map.put("msg","删除失败！");
        }
        return map;
    }

    @RequestMapping("/insertFiles")
    @ResponseBody
    public Map<String,Object> InsertFilesController(@RequestBody Entry entry){
        Map<String,Object> map=new HashMap<>();
        int row=entryService.insertFilesInfo(entry);
        if(row==1){
            map.put("flag","true");
        }else{
            map.put("flag","false");
        }
        return map;
    }

    @RequestMapping("/getFile/{id}")
    public String getFile(@PathVariable int id,Model model){
        Entry entry=entryService.getFileInfoById(id);
        model.addAttribute("entry",entry);

        List<Category> categories= categoryService.getFileCategoryInfo();
        model.addAttribute("categories",categories);
        return "showInfo";
    }

    @RequestMapping("/updateFiles")
    @ResponseBody
    public Map<String,Object> setFiles(@RequestBody Entry entry){
        Map<String,Object> map=new HashMap<>();
        int count=entryService.updateFilesInfo(entry);
        if(count==1){
            map.put("flag","true");
        }else{
            map.put("flag","false");
        }
        return map;
    }
}

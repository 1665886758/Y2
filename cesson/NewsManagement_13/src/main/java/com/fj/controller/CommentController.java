package com.fj.controller;

import com.fj.pojo.Comment;
import com.fj.service.CommentService;
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
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/getInfo/{id}")
    public String getInfo(@PathVariable("id") Integer id, Model model){
        List<Comment> l=commentService.queryCommentInfo(id);
        model.addAttribute("list",l);
        return "comment";
    }

    @RequestMapping("/getId/{id}")
    public String getId(@PathVariable("id") Integer id, Model model){
        model.addAttribute("id",id);
        return "add";
    }


    @RequestMapping("/insert")
    @ResponseBody
    public Map<String,Object> insert(@RequestBody Comment comment){
        Map<String,Object> map=new HashMap<>();
        int row=commentService.addCommentInfo(comment);
        System.out.println(row);
        if(row==1){
            map.put("flag","true");
        }else{
            map.put("flag","false");
        }
        return map;
    }

}

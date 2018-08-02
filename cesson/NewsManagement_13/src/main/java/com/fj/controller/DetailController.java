package com.fj.controller;

import com.fj.pojo.Detail;
import com.fj.service.CommentService;
import com.fj.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RespectBinding;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menu")
public class DetailController {

    @Autowired
    private DetailService detailService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/list/{title}")
    public String list(@PathVariable("title")String title, Model model){
        List<Detail> ls= detailService.getListAll(title);
        model.addAttribute("list",ls);
        return "main";
    }
    @RequestMapping("/delById/{id}")
    @ResponseBody
    public Map<String,Object> delById(@PathVariable("id") Integer id){
        Map<String,Object> map=new HashMap<>();
        int row1=commentService.deleteCommentInfoById(id);
        if(row1>0) {
            int row = detailService.deleteById(id);
            if (row == 1) {
                map.put("flag", "true");
            } else {
                map.put("flag", "false");
            }
        }
        return map;
    }
}

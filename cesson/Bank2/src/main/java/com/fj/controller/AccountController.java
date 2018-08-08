package com.fj.controller;

import com.fj.pojo.Account;
import com.fj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @RequestMapping("/login")
    public String login(Model model, Account account, HttpSession session){
        Map<String,Object> map= accountService.getIsExistCardNo(account);
        int code=Integer.valueOf(map.get("code").toString());
        model.addAttribute("cardNo",account.getCardNo());
        model.addAttribute("password",account.getPassword());
        if(code==403){
            model.addAttribute("msg","登录失败！卡号不存在");
            return "login";
        }else if(code==402){
            model.addAttribute("msg","登录失败！密码错误");
            return "login";
        }else if(code==401){
            model.addAttribute("msg","登录失败！账户已被冻结");
            return "login";
        }else if(code==200){
            //登录成功，携带账户信息
            Account a=(Account)map.get("act");
//            model.addAttribute("lista",a);
            session.setAttribute("lista",a);
            return "main";
        }else{
            return "login";
        }
    }


    @RequestMapping("/conversion/{cardNo}")
    public String conversion(@PathVariable("cardNo") String cardNo, @RequestParam("toCardNo") String toCardNo,@RequestParam("money") Double money, Model model){
        Map<String,Object> map= accountService.moneyOut(cardNo,toCardNo,money);
        int code=Integer.valueOf(map.get("code").toString());
        if(code==404){
            model.addAttribute("msg","目标卡号不存在");
            return "moneyOut";
        }else if(code==400){
            model.addAttribute("msg","目标卡号被冻结");
            return "moneyOut";
        }else if(code==403){
            model.addAttribute("msg","余额不足");
            return "moneyOut";
        }else if(code==200){
            model.addAttribute("msg","转账成功！");
            return "main";
        }else{
            return "moneyOut";
        }
    }
}

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
    public AccountService accountService;

    @RequestMapping("/login")
    public String login(Account account, Model model, HttpSession session){
        Map<String,Object> map= accountService.isExists(account);
        int code=Integer.valueOf(map.get("code").toString());
        if(code == 404){
            // 用户名不存在
            model.addAttribute("errMsg","用户名不存在");

            return "index";
        } else if(code == 403){
            // 密码错误
            model.addAttribute("errMsg","密码错误");
            return "index";
        }else if(code==200){
            //卡号密码无误
            // 2.判断是否冻结
            // 成功
            Account a = (Account) map.get("account");
            System.out.println(a.getStatus()==null);
            if(a.getStatus() == 1){
                // 激活
                session.setAttribute("account",a);//如果成功，设为session作用域
                return "menu";
            } else {
                model.addAttribute("errMsg","账号被冻结");
                return "index";
            }
        }else{
            return "index";
        }
    }

    @RequestMapping("/transfer/{cardNo}")
    public String transfer(@PathVariable("cardNo") String cardNo,
                           @RequestParam("toCardNo") String toCardNo,
                           @RequestParam("money") Double money,
                           Model model
    ) {
        // 转账
        Map<String,Object> map = accountService.transfer(cardNo,toCardNo,money);
        model.addAttribute("msg",map.get("msg"));
        return "moneyOut";
    }
}

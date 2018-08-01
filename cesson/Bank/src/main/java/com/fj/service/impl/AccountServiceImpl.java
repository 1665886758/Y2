package com.fj.service.impl;

import com.fj.mapper.AccountMapper;
import com.fj.pojo.Account;
import com.fj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    public AccountMapper accountMapper;

    @Override
    public Map<String, Object> isExists(Account account) {
        Map<String, Object> map=new HashMap<String, Object>();
        int code = -1;
        String cardNo = account.getCardNo();
        //判段卡号不为空
        if(cardNo == null ){
            code = 404;
        }
        cardNo = cardNo.trim();
        if(cardNo.equals("")){
            code = 404;
        }
        int row=accountMapper.isExistCardNo(cardNo);
        if(row==1){
            //确定卡号不为空
            // 2.判断卡号和密码是否存在对应的账号
           Account a= accountMapper.checkCardNoPassword(account);
            if(a == null){
                // 密码错误
                code = 403;
            } else {
                // 修改状态为已经查到
                code = 200;
                map.put("account",a);
            }
        }else{
            //卡号为空
            code = 404;
        }

        map.put("code",code);
        return map;
    }

    @Override
    public Map<String, Object> transfer(String cardNo, String toCardNo, Double money) {
        /**
         转账
         1.查询转账账户是否存在
         2.是否冻结
         3.余额是否足够
         */
//        1.查询转账账户是否存在
        int row=accountMapper.isExistCardNo(toCardNo);
        String msg=null;
        Map<String, Object> map=new HashMap<String, Object>();
        if(row==1){
            //目标对象已存在
            //2.是否冻结
            int status=accountMapper.checkCardIsUseable(toCardNo);
            if(status==1){
                //账户正常，没有冻结
//                3.余额是否足够
                Double moneyOut=accountMapper.queryBalance(cardNo);
                moneyOut=moneyOut-money;
                if(moneyOut>0){
                    //正常转账开始
                    accountMapper.moneyOut(cardNo,money);
                    accountMapper.moneyIn(toCardNo,money);
                    msg = "转账成功";
                }else{
                    msg = "账户余额不足";
                }
            }else{
                msg = "目标账号已被冻结";
            }
        }else {
            // 不存在(到账账号)
            msg = "目标账号不存在";
        }
        map.put("msg",msg);

        return map;
    }

}

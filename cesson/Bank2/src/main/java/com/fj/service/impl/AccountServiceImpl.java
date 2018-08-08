package com.fj.service.impl;

import com.fj.mapper.AccountMapper;
import com.fj.mapper.TransactionRecordMapper;
import com.fj.pojo.Account;
import com.fj.pojo.TransactionRecord;
import com.fj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service("accountService")
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private TransactionRecordMapper transactionRecordMapper;

    @Override
    public Map<String, Object> getIsExistCardNo(Account account) {
        /**
         * 逻辑判断
         * 1、卡号是否存在
         * 2、卡号、密码对应的用户是否存在
         * 3、用户是否被冻结
         */
        Map<String, Object> map = new HashMap<>();
        int code = -1;
        String cardNo = account.getCardNo().trim(); //去空格
        if (cardNo == null || cardNo == "") {
            //卡号为空
            code = 404;
        } else {
            //卡号不为空
            //1).卡号是否存在
            Account account2= accountMapper.isExistCardNo(cardNo);
            if (account2!=null) {
                //卡号存在
                //2).判断卡号和密码是否对应相应的用户
                Account act = accountMapper.isExistCardNoAndPwd(account);
                if (act != null) {
                    //用户存在
                    //3).用户是否被冻结
                    if (act.getStatus() == 1) {
                        //用户状态正常
                        map.put("act", act);
                        code = 200;
                    } else {
                        //用户被冻结
                        code = 401;
                    }
                } else {
                    //用户不存在
                    code = 402;
                }
            } else {
                //卡号不存在
                code = 403;
            }
            map.put("code", code);
        }
        return map;
    }

    @Override
    public Map<String, Object> moneyOut(String cardNo, String toCardNo, Double money) {
        /**
         * 1.判断转账卡号是否存在
         * 2.转账卡号是否冻结
         * 3.余额是否足够
         */
        Map<String, Object> map = new HashMap<>();
        int code=-1;
        Account account=accountMapper.isExistCardNo(toCardNo);
        if(account!=null){
            //1).to卡号存在
            //2).转账卡号是否冻结
            if(account.getStatus()==0){
                //卡号冻结
                code=400;
            }else{
                //卡号状态正常
                //3).余额是否足够
                double balance=account.getBalance()-money;
                if(balance>0){
                    //余额足够
                    //执行转账操作》》》》》
                    accountMapper.moneyOut(cardNo,money);
                    accountMapper.moneyIn(toCardNo,money);
                    TransactionRecord t=new TransactionRecord();
//                    cardNo,transactionDate,transactionAmount,balance,transactionType,remark
                    t.setCardNo(cardNo);
                    t.setTransactionAmount(money);
                    t.setBalance(balance);
                    t.setTransactionType("取款》");
                    transactionRecordMapper.addInfo(t);

                    TransactionRecord t2=new TransactionRecord();
                    t2.setCardNo(toCardNo);
                    t2.setTransactionAmount(money);
                    Account a=accountMapper.isExistCardNo(toCardNo);    //获取余额数+转账金额
                    Double b=a.getBalance();
                    Double m=b+money;
                    t2.setBalance(m);
                    t2.setTransactionType("存款》");
                    transactionRecordMapper.addInfo(t2);
                    code=200;
                }else{
                    //余额不足
                    code=403;
                }
            }
        }else{
            //to卡号不存在
            code=404;
        }
        map.put("code",code);
        return map;
    }
}

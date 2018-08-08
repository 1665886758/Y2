package com.fj.service;

import com.fj.pojo.Account;
import java.util.Map;

public interface AccountService {

    /**
     * 查询卡号是否存在业务
     */
    public Map<String,Object> getIsExistCardNo(Account account);

    /**
     * 转账
     */
    public Map<String,Object> moneyOut(String cardNo,String toCardNo,Double money);

}

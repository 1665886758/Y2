package com.fj.service;

import com.fj.pojo.Account;
import org.springframework.stereotype.Service;
import java.util.Map;


public interface AccountService {


    /**
     * 查询卡号and密码是否存在业务（login）
     * @param account
     * @return
     */
    public Map<String,Object> isExists(Account account);

    /**
     *转账
     */
    public Map<String,Object> transfer(String cardNo, String toCardNo, Double money);
}

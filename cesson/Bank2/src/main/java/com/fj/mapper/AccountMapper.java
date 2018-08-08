package com.fj.mapper;

import com.fj.pojo.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    /**
     * 查询输入卡号是否存在
     */
    public Account isExistCardNo(@Param("cardNo")String cardNo);


    /**
     *查询卡号、密码对应的用户是否存在
     */
    public Account isExistCardNoAndPwd(Account account);

    /**
     * 出账
     */
    public int moneyOut(@Param("cardNo") String cardNo,@Param("money") Double money);

    /**
     * 收帐
     */
    public int moneyIn(@Param("tocardNo")String tocardNo,@Param("money")Double money);

}

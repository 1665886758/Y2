package com.fj.mapper;

import com.fj.pojo.Account;
import com.fj.pojo.TransactionRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {


    /**
     * 检查某个卡号是否存在
     * @param cardNo
     * @return
     */
    int isExistCardNo(@Param("cardNo") String cardNo);

    /**
     * 检查卡号和密码是否存在对应的账号
     */
    Account checkCardNoPassword(Account account);


    /**
     转账
     1.查询转账账户是否存在
     2.是否冻结
     3.余额是否足够
     */

    /**
     * 2.是否冻结
     * @param toCardNo
     * @return
     */
    int checkCardIsUseable(@Param("cardNo")String toCardNo);

    /**
     * 3.余额是否足够
     */
    double queryBalance(@Param("cardNo")String cardNo);


    void moneyOut(@Param("cardNo")String cardNo, @Param("money")Double money);

    void moneyIn(@Param("toCardNo")String toCardNo,@Param("money") Double money);
//    /**
//     * 登录
//     */
//    public Account bankLogin(@Param("cardNo") String cardNo, @Param("password") String password);
//
//    /**
//     * 查询余额
//     */
//    public Account bankBalanceInfo(@Param("id") Integer id);


}

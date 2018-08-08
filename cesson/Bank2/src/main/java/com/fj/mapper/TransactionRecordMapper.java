package com.fj.mapper;

import com.fj.pojo.Account;
import com.fj.pojo.TransactionRecord;
import org.apache.ibatis.annotations.Param;

public interface TransactionRecordMapper {

    /**
     * 添加转账信息
     */
    public int addInfo(TransactionRecord transactionRecord);


}

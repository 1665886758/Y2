package com.fj.mapper;

import com.fj.pojo.TransactionRecord;

import java.util.List;

public interface TransactionRecordMapper {

    /**
     * 查询交易记录
     */
    public List<TransactionRecord> bankTransactionRecord();
}

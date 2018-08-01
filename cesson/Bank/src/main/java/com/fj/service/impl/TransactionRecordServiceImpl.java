package com.fj.service.impl;

import com.fj.mapper.TransactionRecordMapper;
import com.fj.pojo.TransactionRecord;
import com.fj.service.TransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("transactionRecordService")
public class TransactionRecordServiceImpl implements TransactionRecordService {

    @Autowired
    public TransactionRecordMapper transactionRecordMapper;

    @Override
    public List<TransactionRecord> getBankTransactionRecordInfo() {
        return transactionRecordMapper.bankTransactionRecord();
    }
}

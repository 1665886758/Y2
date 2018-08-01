package com.fj.controller;

import com.fj.pojo.TransactionRecord;
import com.fj.service.AccountService;
import com.fj.service.TransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/transactionRecord")
public class TransactionRecordController {

    @Autowired
    public TransactionRecordService transactionRecordService;

    @RequestMapping("/bankListInfo")
    public String bankListInfo(Model model){
       List<TransactionRecord> list= transactionRecordService.getBankTransactionRecordInfo();
        model.addAttribute("list",list);
        return "jsp/menu";
    }
}

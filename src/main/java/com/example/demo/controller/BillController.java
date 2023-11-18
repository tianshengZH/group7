package com.example.demo.controller;

import com.example.demo.domin.Accounts;
import com.example.demo.domin.Bills;
import com.example.demo.received.BillsReceive;
import com.example.demo.result.Result;
import com.example.demo.service.AccountService;
import com.example.demo.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController
@RequestMapping("/bills")
public class BillController {
    @Autowired
    BillsService billsService;
    @Autowired
    AccountService accountService;
    @RequestMapping("/add_bills")
    @ResponseBody
    public Result<Boolean> addBills(@RequestBody BillsReceive billsReceive){
        billsService.insertBills(billsReceive);
        return Result.success(true);
    }
    @RequestMapping("/get_bills")
    @ResponseBody
    public Result<ArrayList<Bills>> getBills(@RequestBody BillsReceive billsReceive){
        ArrayList<Bills> bills = billsService.getAllBillsByPid(billsReceive);
        return Result.success(bills);
    }
    @RequestMapping("/withdraw_money")
    public Result<Float> withdrawMoney(int bid, String accountNumber,boolean flag, int type){
        Accounts accounts = accountService.getAccountBynumber(accountNumber);
        float money = billsService.withdrawMoney(accounts.getAcId(),bid,type,flag);
        return Result.success(money);
    }
    @RequestMapping("/withdraw_moneyList")
    public Result<Float> withdrawMoney(ArrayList<Integer> bids, String accountNumber,boolean flag, int type){
        Accounts accounts = accountService.getAccountBynumber(accountNumber);
        float money = billsService.withdrawAllMoney(accounts.getAcId(),bids,type,flag);
        return Result.success(money);
    }


}

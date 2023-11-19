package com.example.demo.controller;

import com.example.demo.domin.Accounts;
import com.example.demo.domin.Bills;
import com.example.demo.received.BillsReceive;
import com.example.demo.received.*;
import com.example.demo.result.Result;
import com.example.demo.service.AccountService;
import com.example.demo.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.util.*;
import jakarta.servlet.http.*;
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
    public Result<Boolean> addBills(HttpServletRequest request, @RequestBody BillsReceive billsReceive){
        WebUtil webUtil = new WebUtil();
        String id = webUtil.getUserIdFromCookies(request);
        billsReceive.setUid(Integer.parseInt(id));
        billsService.insertBills(billsReceive);
        return Result.success(true);
    }
    @RequestMapping("/get_bills")
    @ResponseBody
    public Result<ArrayList<Bills>> getBills(HttpServletRequest request,@RequestBody BillsReceive billsReceive){

        ArrayList<Bills> bills = billsService.getAllBillsByPid(billsReceive);
        return Result.success(bills);
    }
    @RequestMapping("/withdraw_money")
    public Result<Float> withdrawMoney(HttpServletRequest request, @RequestBody WithdrawBody withdrawBody){

        Accounts accounts = accountService.getAccountBynumber(withdrawBody.getAccountNumber());
        float money = billsService.withdrawMoney(accounts.getAcId(),withdrawBody.getBid(), withdrawBody.getType(), withdrawBody.isFlag());
        return Result.success(money);
    }
    @RequestMapping("/withdraw_moneyList")
    public Result<Float> withdrawMoneyList(HttpServletRequest request,@RequestBody WithdrawBodyList withdrawBodyList){
        Accounts accounts = accountService.getAccountBynumber(withdrawBodyList.getAccountNumber());
        float money = billsService.withdrawAllMoney(accounts.getAcId(),withdrawBodyList.getBid(),
                withdrawBodyList.getType(), withdrawBodyList.isFlag());
        return Result.success(money);
    }


}

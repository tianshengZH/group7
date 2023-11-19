package com.example.demo.controller;

import com.example.demo.dao.AccountsDao;
import com.example.demo.dao.BillsDao;
import com.example.demo.domin.Accounts;
import com.example.demo.domin.Bills;
import com.example.demo.received.BillsReceive;
import com.example.demo.received.*;
import com.example.demo.result.Result;
import com.example.demo.service.AccountService;
import com.example.demo.service.BillsService;
import com.example.demo.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @Autowired
    SellerService sellerService;
    @Autowired
    AccountsDao accountsDao;
    @Autowired
    BillsDao billsDao;
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

    public Result<ArrayList<Bills>> getBills( HttpServletRequest request, @RequestParam String pName){
        WebUtil webUtil = new WebUtil();
        String id = webUtil.getUserIdFromCookies(request);

        int pid = sellerService.getPidByName(Integer.parseInt(id),pName);

        ArrayList<Bills> bills = billsService.getAllBillsByPid(pid);

        return Result.success(bills);
    }

    @RequestMapping("/withdraw_moneyList")
    public Result<WithdrawMoneyBody> withdrawMoneyList(HttpServletRequest request,@RequestBody WithdrawBodyList withdrawBodyList){
        WebUtil webUtil = new WebUtil();
        String id = webUtil.getUserIdFromCookies(request);
        Accounts accounts = accountService.getAccountsByUserAndType(Integer.parseInt(id),withdrawBodyList.getType());
        if(withdrawBodyList.getType() == 1){
            withdrawBodyList.setFlag(true);
        }
        float money = billsService.withdrawAllMoney(accounts.getAcId(),withdrawBodyList.getBid(),
                withdrawBodyList.getType(), withdrawBodyList.isFlag());
        //手续费
        float money1 = billsService.showCommission(withdrawBodyList.getBid(),
                withdrawBodyList.getType());
        WithdrawMoneyBody withdrawMoneyBody =new WithdrawMoneyBody();
        withdrawMoneyBody.setMoney(money);
        withdrawMoneyBody.setCommission(money1);
        return Result.success(withdrawMoneyBody);
    }
    @RequestMapping("/show_commission")
    public Result<Float> getCommission(HttpServletRequest request,@RequestBody WithdrawBodyList withdrawBodyList){
        WebUtil webUtil = new WebUtil();
        //String id = webUtil.getUserIdFromCookies(request);
        //Accounts accounts = accountServzaice.getAccountsByUserAndType(Integer.parseInt(id),withdrawBodyList.getType());
        if(withdrawBodyList.getType() == 1){
            withdrawBodyList.setFlag(false);
        }
        float money = billsService.showCommission(withdrawBodyList.getBid(),
                withdrawBodyList.getType());
        return Result.success(money);
    }

}

package com.example.demo.controller;

import com.example.demo.received.BindBody;
import com.example.demo.service.AccountService;
import com.example.demo.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domin.*;
import com.example.demo.result.*;
import com.example.demo.util.*;
import jakarta.servlet.http.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    BillsService billsService;
    @Autowired
    LoginController loginController;
    @RequestMapping("/show_account_money")
    @ResponseBody
    public Result<Accounts> showAccountMoney(String accountNumber){
        Accounts accounts = accountService.getAccountBynumber(accountNumber);

        return Result.success(accounts);
    }

    @RequestMapping("/bind_account")
    @ResponseBody
    public Result<Boolean> bindAccount(HttpServletRequest request, @RequestBody BindBody bindBody){

        WebUtil webUtil = new WebUtil();
        int uid =Integer.parseInt(webUtil.getUserIdFromCookies(request));
        bindBody.setUserId(uid);
        accountService.bindAccount(bindBody);
        return Result.success(true);
    }
    @RequestMapping("/update_account")
    @ResponseBody
    public Result<Boolean> updateAccount(HttpServletRequest request, @RequestBody BindBody bindBody){
        WebUtil webUtil = new WebUtil();
        int uid =Integer.parseInt(webUtil.getUserIdFromCookies(request));
        bindBody.setUserId(uid);

        accountService.updateAccount(bindBody);
        return Result.success(true);
    }
    @RequestMapping("/delete_account")
    @ResponseBody
    public Result<Boolean> deleteAccount(HttpServletRequest request, @RequestBody BindBody bindBody){
        WebUtil webUtil = new WebUtil();
        int uid =Integer.parseInt(webUtil.getUserIdFromCookies(request));
        bindBody.setUserId(uid);
        accountService.deleteAccount(bindBody);
        return Result.success(true);
    }
    @RequestMapping("/get_accounts")
    public Result<ArrayList<Accounts>> getAccounts(HttpServletRequest request,@RequestBody BindBody bindBody){
        WebUtil webUtil = new WebUtil();
        int uid =Integer.parseInt(webUtil.getUserIdFromCookies(request));
        bindBody.setUserId(uid);
        ArrayList<Accounts> accounts =accountService.getAllAccounts(bindBody);
        return Result.success(accounts);
    }
}

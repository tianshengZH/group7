package com.example.demo.service;

import com.example.demo.dao.AccountsDao;
import com.example.demo.received.BindBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domin.Users;
import com.example.demo.domin.Accounts;

import java.util.ArrayList;

@Service
public class AccountService {
    @Autowired
    AccountsDao accountsDao;
    @Autowired
    UserService userService;
    public boolean bindAccount(BindBody bindBody){
        Users users = userService.getByEmail(bindBody.getEmail());
        accountsDao.insertIntoAccounts(users.getUserid(),bindBody.getNewNumber(),bindBody.getAcType());
        return true;
    }
    public boolean updateAccount(BindBody bindBody){
        Users users = userService.getByEmail(bindBody.getEmail());
        Accounts accounts =accountsDao.getOneAccount(users.getUserid(),bindBody.getOldNumber(),bindBody.getAcType());
        if(accounts == null){
            return false;
        }
        bindBody.setUserId(users.getUserid());
        accountsDao.updateAccountNumber(bindBody);
        accountsDao.updateAccountType(bindBody);
        return true;
    }
    public boolean deleteAccount(BindBody bindBody){
        Users users = userService.getByEmail(bindBody.getEmail());
        Accounts accounts =accountsDao.getOneAccount(users.getUserid(),bindBody.getOldNumber(),bindBody.getAcType());
        if(accounts == null){
            return false;
        }
        bindBody.setUserId(users.getUserid());
        bindBody.setAcType(2);
        accountsDao.updateAccountType(bindBody);
        return true;
    }
    public Accounts getAccount(BindBody bindBody){
        Users users = userService.getByEmail(bindBody.getEmail());
        Accounts accounts =accountsDao.getOneAccount(users.getUserid(),bindBody.getOldNumber(),bindBody.getAcType());
        return accounts;
    }
    public Accounts getAccountBynumber(String number){

        Accounts accounts =accountsDao.getAccountsByNumber(number);
        return accounts;
    }
    public ArrayList<Accounts> getAllAccounts(BindBody bindBody){
        Users users = userService.getByEmail(bindBody.getEmail());
        ArrayList<Accounts> accounts =accountsDao.getAllAccountsById(users.getUserid());
        return accounts;
    }

}

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

        accountsDao.insertIntoAccounts(bindBody.getUserId(),bindBody.getNewNumber(),bindBody.getAcType());
        return true;
    }
    public boolean updateAccount(BindBody bindBody){

        Accounts accounts =accountsDao.getOneAccount(bindBody.getUserId(),bindBody.getOldNumber(),bindBody.getAcType());
        if(accounts == null){
            return false;
        }
      //  bindBody.setUserId(users.getUserid());
        accountsDao.updateAccountNumber(bindBody);
        accountsDao.updateAccountType(bindBody);
        return true;
    }
    public boolean deleteAccount(BindBody bindBody){

        Accounts accounts =accountsDao.getOneAccount(bindBody.getUserId(),bindBody.getOldNumber(),bindBody.getAcType());
        if(accounts == null){
            return false;
        }
        bindBody.setAcType(2);
        accountsDao.updateAccountType(bindBody);
        return true;
    }
    public Accounts getAccount(BindBody bindBody){

        Accounts accounts =accountsDao.getOneAccount(bindBody.getUserId(),bindBody.getOldNumber(),bindBody.getAcType());
        return accounts;
    }
    public Accounts getAccountBynumber(String number){

        Accounts accounts =accountsDao.getAccountsByNumber(number);
        return accounts;
    }
    public ArrayList<Accounts> getAllAccounts(BindBody bindBody){
        ArrayList<Accounts> accounts =accountsDao.getAllAccountsById(bindBody.getUserId());
        return accounts;
    }

}

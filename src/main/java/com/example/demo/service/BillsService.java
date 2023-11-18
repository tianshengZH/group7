package com.example.demo.service;

import com.example.demo.dao.AccountsDao;
import com.example.demo.dao.BillsDao;
import com.example.demo.domin.*;
import com.example.demo.dao.SellersDao;
import com.example.demo.received.BillsReceive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service

public class BillsService {
    public static float COMMISSION = 0.02f;
    @Autowired
    BillsDao billsDao;
    @Autowired
    SellerService sellerService;
    @Autowired
    SellersDao sellersDao;
    @Autowired
    UserService userService;
    @Autowired
    AccountService accountService;
    @Autowired
    AccountsDao accountsDao;
    //新增账单
    public boolean insertBills(BillsReceive billsReceive){
        if(billsReceive.getUid() == 0){
            Users users = userService.getByEmail(billsReceive.getEmail());
            billsReceive.setUid(users.getUserid());
        }
        if(billsReceive.getPid() ==0){
            Sellers sellers = sellersDao.getSellerByName(billsReceive.getUid(),billsReceive.getpName());
            billsReceive.setPid(sellers.getpId());
        }
        billsDao.insertBills(billsReceive.getPid(),billsReceive.getDollarIncome());
        return true;
    }
    public ArrayList<Bills> getAllBillsByPid(BillsReceive billsReceive){
        if(billsReceive.getUid() == 0){
            Users users = userService.getByEmail(billsReceive.getEmail());
            billsReceive.setUid(users.getUserid());
        }
        if(billsReceive.getPid() ==0){
            Sellers sellers = sellersDao.getSellerByName(billsReceive.getUid(),billsReceive.getpName());
            billsReceive.setPid(sellers.getpId());
        }
        return billsDao.getAllBills(billsReceive.getPid());
    }

    public float withdrawAllMoney(int accountId,ArrayList<Integer> bids,int types,boolean flag){
        //type == 0 ,人民币提现， type == 1 美元提现
        //flag == false,试算， flag == true,真正提现
        //提现， 1. 找到对应账单的金额 2,在一个事务中 账户入钱 , 账单状态改变
        float total= 0 ;
        for(int i =0;i<bids.size();i++){
            int bid = bids.get(i);

            total +=withdrawMoney(accountId,bid,types,flag);

        }

        return total;
    }
    public float showCommission(int bid,int type){
        Bills bills = billsDao.getBills(bid);

            if (bills == null) {
                return 0;
            }
            if (type != bills.getBillStatus()) {
                return 0;
            }
            if (type == 0) {
                return bills.getDollarIncome() * 7 * COMMISSION;
            }
            return bills.getDollarIncome() * COMMISSION;

    }
    public float withdrawMoney(int accountId,int bid,int type,boolean flag){
        //type == 0 ,人民币提现， type == 1 美元提现
        //提现， 1. 找到对应账单的金额 2,在一个事务中 账户入钱 , 账单状态改变
        Bills bills = billsDao.getBills(bid);
        if(bills == null){
            return 0;
        }
        if(flag) {
            withdraw1(accountId, bid, type, bills.getDollarIncome());
        }
       if(type == 0) {
            return bills.getDollarIncome()*7*(1-COMMISSION);
        }
        return bills.getDollarIncome()*(1-COMMISSION);
    }
    @Transactional
    public void withdraw1(int accountId,int bid,int type,float income){
        //float commission = 0.02f;
        float res = income*(1-COMMISSION);

        if(type == 0) {
            res = res*7;
            accountsDao.withdrawRMB(accountId,res);
        }else {
            accountsDao.withdrawDollar(accountId, res);
        }
        billsDao.updateStatus(bid);
        return ;
    }

}

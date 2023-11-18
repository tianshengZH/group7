package com.example.demo.service;

import com.example.demo.dao.AccountsDao;
import com.example.demo.dao.SellersDao;
import com.example.demo.received.BindSellerBody;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domin.*;

import java.util.ArrayList;

@Service
public class SellerService {
    @Autowired
    UserService userService;
    @Autowired
    AccountsDao accountsDao;

    @Autowired
    SellersDao sellersDao;
    public boolean bindSeller(BindSellerBody bindSellerBody){
        if(bindSellerBody.getUserId() == 0) {
            Users users = userService.getByEmail(bindSellerBody.getEmail());
            bindSellerBody.setUserId(users.getUserid());

        }
        Sellers sellers = sellersDao.getSellerByName(bindSellerBody.getUserId(),bindSellerBody.getNewName());
        if(sellers !=null){
            return false;
        }
        sellersDao.insertSellers(bindSellerBody);
        return true;
    }
    public boolean deleteSeller(BindSellerBody bindSellerBody){
        if(bindSellerBody.getUserId() == 0){
            Users users = userService.getByEmail(bindSellerBody.getEmail());
            bindSellerBody.setUserId(users.getUserid());

        }
        sellersDao.deleteSeller(bindSellerBody);
        return true;
    }
    public boolean updateSellerName(BindSellerBody bindSellerBody){
        if(bindSellerBody.getUserId() == 0){
            Users users = userService.getByEmail(bindSellerBody.getEmail());
            bindSellerBody.setUserId(users.getUserid());

        }
        sellersDao.updateSellerName(bindSellerBody);
        return true;
    }
    public Sellers getSellerByUserName(BindSellerBody bindSellerBody){
        if(bindSellerBody.getUserId() == 0){
            Users users = userService.getByEmail(bindSellerBody.getEmail());
            bindSellerBody.setUserId(users.getUserid());

        }
        return sellersDao.getSellerByName(bindSellerBody.getUserId(),bindSellerBody.getNewName());
    }

    public ArrayList<Sellers> getAllSellers(BindSellerBody bindSellerBody){
        if(bindSellerBody.getUserId() == 0){
            Users users = userService.getByEmail(bindSellerBody.getEmail());
            bindSellerBody.setUserId(users.getUserid());

        }
        return sellersDao.getAllSellersById(bindSellerBody.getUserId());
    }

}

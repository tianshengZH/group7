package com.example.demo.controller;

import com.example.demo.domin.Sellers;
import com.example.demo.received.BindSellerBody;
import com.example.demo.result.Result;
import com.example.demo.service.SellerService;
import com.example.demo.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    SellerService sellerService;



    @RequestMapping("/bind_seller")
    @ResponseBody
    public Result<Boolean> bindSeller(HttpServletRequest request, @RequestBody BindSellerBody bindSellerBody){
        WebUtil webUtil = new WebUtil();
        String id = webUtil.getUserIdFromCookies(request);
        bindSellerBody.setUserId(Integer.parseInt(id));
        sellerService.bindSeller(bindSellerBody);
        return Result.success(true);
    }
    @RequestMapping("/update_seller")
    @ResponseBody
    public Result<Boolean> updateSeller(HttpServletRequest request,@RequestBody BindSellerBody bindSellerBody){
        WebUtil webUtil = new WebUtil();
        String id = webUtil.getUserIdFromCookies(request);
        bindSellerBody.setUserId(Integer.parseInt(id));
        sellerService.updateSellerName(bindSellerBody);


        return Result.success(true);
    }
    @RequestMapping("/delete_seller")
    @ResponseBody
    public Result<Boolean> deleteSeller(HttpServletRequest request,@RequestBody BindSellerBody bindSellerBody){
        WebUtil webUtil = new WebUtil();
        String id = webUtil.getUserIdFromCookies(request);
        bindSellerBody.setUserId(Integer.parseInt(id));
        sellerService.deleteSeller(bindSellerBody);
        return Result.success(true);
    }
    @RequestMapping("/get_sellers")
    public Result<ArrayList<Sellers>> getSellers(HttpServletRequest request,@RequestBody BindSellerBody bindSellerBody){
        WebUtil webUtil = new WebUtil();
        String id = webUtil.getUserIdFromCookies(request);
        bindSellerBody.setUserId(Integer.parseInt(id));
        ArrayList<Sellers> sellers =sellerService.getAllSellers(bindSellerBody);
        return Result.success(sellers);
    }
}

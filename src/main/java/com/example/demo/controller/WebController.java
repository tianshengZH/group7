package com.example.demo.controller;


import com.example.demo.result.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import com.example.demo.domin.*;

import java.util.ArrayList;

@Controller
public class WebController {
    @Autowired
    UserController userController;
    @Autowired
    SellerController sellerController;
    @Autowired
    AccountController accountController;
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // 返回注册页面的视图名称
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // 返回登录页面的视图名称
    }
    @GetMapping("/index")
    public String returnIndex() {
        return "index"; // 返回index页面的视图名称
    }
    @GetMapping("/bill")
    public String toBillPage() {

        return "bill"; // 返回index页面的视图名称
    }
    @GetMapping("/basic")
    public String dashboard(Model model, HttpServletRequest request) {
        RestTemplate restTemplate = new RestTemplate();

        // 获取用户信息
        Result<Users> users = userController.getUser(request);

        model.addAttribute("user", users.getData());
        // 获取账户信息
        Result<ArrayList<Accounts>> accounts = accountController.getAccounts(request);
        model.addAttribute("accounts", accounts.getData());

        // 获取店铺信息
        Result<ArrayList<Sellers>> sellers = sellerController.getSellers(request);
        model.addAttribute("sellers", sellers.getData());

        return "basic"; // Thymeleaf模板的名称
    }
}

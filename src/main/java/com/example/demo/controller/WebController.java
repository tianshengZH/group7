package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebController {

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
}

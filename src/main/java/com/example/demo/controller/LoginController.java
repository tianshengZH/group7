package com.example.demo.controller;

import com.example.demo.received.Login;
import com.example.demo.received.RegisterBody;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.result.*;
@RestController
@RequestMapping("/index")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public Result<Boolean> login(@RequestBody Login login){
        System.out.println(login.getPasswords());
        boolean flag = loginService.login(login);

        if(flag){
            //
            return Result.success(true);
        }else{
            //
            return Result.error(CM.LOGINERROR);
        }
    }
    @RequestMapping("/register")
    @ResponseBody
    public Result<Boolean> register(@RequestBody RegisterBody registerBody){
        boolean flag = loginService.register(registerBody);
        if(flag){
            return Result.success(true);
        }else{
            return Result.error(CM.REGISTERERROR);
        }
    }

}

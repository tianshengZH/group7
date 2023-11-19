package com.example.demo.controller;

import com.example.demo.received.Login;
import com.example.demo.received.RegisterBody;
import com.example.demo.service.LoginService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.result.*;
import jakarta.servlet.http.*;
import com.example.demo.domin.*;
import com.example.demo.util.*;
@RestController
@RequestMapping("/index")
public class LoginController {

    @Autowired
    LoginService loginService;
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    @ResponseBody
    public Result<Boolean> login(HttpServletResponse response,@RequestBody Login login){

        boolean flag = loginService.login(login);
        WebUtil webUtil= new WebUtil();
        if(flag){

            Users users = userService.getByEmail(login.getEmail());

            webUtil.addUserIdToCookie(response,String.valueOf(users.getUserid()));

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

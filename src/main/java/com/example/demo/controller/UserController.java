package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.domin.Users;
import com.example.demo.result.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/db/get")
    @ResponseBody
    public Result<Users> dbget(){
        Users users = userService.getByEmail("test@u.com");
        return Result.success(users);
    }
}

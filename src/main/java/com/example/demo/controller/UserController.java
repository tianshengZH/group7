package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.util.WebUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.domin.Users;
import com.example.demo.result.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/get_user")
    @ResponseBody
    public Result<Users> getUser(HttpServletRequest request){
        WebUtil webUtil = new WebUtil();
        int uid = Integer.valueOf(webUtil.getUserIdFromCookies(request));
        Users users = userService.getById(uid);
        return Result.success(users);
    }

}

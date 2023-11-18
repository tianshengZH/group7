package com.example.demo.service;

import com.example.demo.dao.UsersDao;
import com.example.demo.domin.Users;
import com.example.demo.received.Login;
import com.example.demo.received.RegisterBody;
import com.example.demo.util.MD5;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginService {
    @Autowired
    UsersDao usersDao;
    @Autowired
    UserService userService;
    public boolean login(Login login){
        Users users= userService.getByEmail(login.getEmail());
        if(users == null){
            return false;
        }
        String ps = MD5.MD5encoder(login.getPasswords());

        if(ps.equals(users.getPasswords())){
            return true;
        }else{
            return false;
        }
    }
    public boolean register(RegisterBody registerBody){
        Users users= userService.getByEmail(registerBody.getEmail());
        if(users!=null){
            return false;
        }
        userService.insertIntoUsers(registerBody.getEmail(),registerBody.getUserName(),registerBody.getPasswords());
        return true;
    }
}

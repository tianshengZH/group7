package com.example.demo.service;

import com.example.demo.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domin.Users;

@Service
public class UserService {
    @Autowired
    UsersDao usersDao;
    public Users getByEmail(String email){
        return usersDao.getByEmail(email);
    }
    public Users insertIntoUsers(String email,String userName,String passwords){
        return usersDao.insertIntoUsers(email,userName,passwords);
    }
}

package com.myth.springboot.service;

import com.myth.springboot.entity.User;
import com.myth.springboot.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginMapper mapper;
    //登陆
    public User login(String username, String password){
        User user=mapper.selectUser(username,password);
        user.toString();
        return user;
    }
}

package com.myth.springboot.service;

import com.myth.springboot.dao.AdminMapper;
import com.myth.springboot.dao.UserMapper;
import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper mapper;

    public int userInsert(User user){
        return mapper.userInsert(user);
    }
    public int userUpdate(User user){
        return mapper.userUpdate(user);
    }
    public List<User> userSelect(User user){
        return mapper.userSelect(user);
    }
    //用户的操作
   public int userDelete(User user){
        return mapper.userDelete(user);
   }

    public List<User> selectUserByName(String u_name){
        return mapper.selectUserByName(u_name);
    }

    public List<User> selectUserByNames(String u_name){
        return mapper.selectUserByNames(u_name);
    }

}

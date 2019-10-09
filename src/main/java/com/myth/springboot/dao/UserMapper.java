package com.myth.springboot.dao;

import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    //添加用户
    int userInsert(User user);
    //查询用户
    List<User> userSelect(User user);
    //修改用户
    int userUpdate(User user);
    //删除用户
    int userDelete(User user);

    List<User> selectUserByName(String u_name);



}

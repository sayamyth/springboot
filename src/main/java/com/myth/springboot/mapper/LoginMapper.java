package com.myth.springboot.mapper;

import com.myth.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    //查找用户
    User selectUser(String name,String password );
}

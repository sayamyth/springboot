package com.myth.springboot.dao;

import com.myth.springboot.entity.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TypeMapper {
    //添加用户
    int typeInsert(Type type);
    //查询用户
    List<Type> typeSelect(Type levtypeel);
    //修改用户
    int typeUpdate(Type type);
    //删除用户
    int typeDelete(Type type);



}

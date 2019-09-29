package com.myth.springboot.service;

import com.myth.springboot.dao.TypeMapper;
import com.myth.springboot.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    TypeMapper mapper;

    public int typeInsert(Type type){
        return mapper.typeInsert(type);
    }
    public int typeUpdate(Type type){
        return mapper.typeUpdate(type);
    }
    public List<Type> typeSelect(Type type){
        return mapper.typeSelect(type);
    }
    //用户的操作
    public int typeDelete(Type type){
        return mapper.typeDelete(type);
   }





}

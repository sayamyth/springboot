package com.myth.springboot.service;

import com.myth.springboot.dao.AdminMapper;
import com.myth.springboot.dao.SMapper;
import com.myth.springboot.dao.TMapper;
import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.*;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SService {
    @Autowired
    SMapper mapper;
    public Result selectByUid(String u_id){
        return mapper.selectByUid(u_id);
    }
    public int insertMark(String te_id,String user_id,String point){
        return mapper.insertMark(te_id,user_id,point);
    }
    public List<Mark> selectMark(String user_id){
        return mapper.selectMark(user_id);
    }
}

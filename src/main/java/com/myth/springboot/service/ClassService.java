package com.myth.springboot.service;

import com.myth.springboot.dao.AdminMapper;
import com.myth.springboot.dao.ClassMapper;
import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassMapper mapper;

    //班级新增，查询，修改，删除
    public int classInsert(Class cla){
        return mapper.classInsert(cla);
    }
    public List<Class> classSelect(Class cla){
        return mapper.classSelect(cla);
    }
    public int classUpdateById(Class cla){
        return mapper.classUpdateById(cla);
    }
    public int classDeleteById(Class cla){
        return mapper.classDeleteById(cla);
    }






}

package com.myth.springboot.service;

import com.myth.springboot.dao.AdminMapper;
import com.myth.springboot.dao.TeacherMapper;
import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherMapper mapper;



   //查询教师所有信息
    public List<Teacher> teacherSelect(Teacher teacher){
        return mapper.teacherSelect(teacher);
    }
    //修改教师信息
    public int teacherUpdate(Teacher teacher){
        return mapper.teacherUpdate(teacher);
    }
    //删除教师
    public int teacherDelete(Teacher teacher){
        return mapper.teacherDelete(teacher);
    }
    public int teacherDeleteByUserId(Teacher teacher){
        return mapper.teacherDeleteByUserId(teacher);
    }


    public int teacherAdd(Teacher teacher){
        return mapper.teacherAdd(teacher);
    }
}

package com.myth.springboot.service;

import com.myth.springboot.dao.AdminMapper;
import com.myth.springboot.dao.StudentMapper;
import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentMapper mapper;
    //查询用户带上可以附带条件
    public List<Student> studentSelect(Student student){
        return mapper.studentSelect(student);
    }
    public int studentUpdateById(Student student){
        return mapper.studentUpdateById(student);
    }
    public int studentDeleteById(Student student){
        return mapper.studentDeleteById(student);
    }

}

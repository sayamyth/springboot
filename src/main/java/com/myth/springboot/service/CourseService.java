package com.myth.springboot.service;


import com.myth.springboot.dao.CourseMapper;

import com.myth.springboot.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseMapper mapper;

    //班级新增，查询，修改，删除
    public int courseInsert(Course course){
        return mapper.courseInsert(course);
    }
    public List<Course> courseSelect(Course course){
        return mapper.courseSelect(course);
    }
    public int courseUpdateById(Course course){
        return mapper.courseUpdateById(course);
    }
    public int courseDeleteById(Course course){
        return mapper.courseDeleteById(course);
    }






}

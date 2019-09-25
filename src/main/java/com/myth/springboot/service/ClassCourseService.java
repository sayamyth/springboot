package com.myth.springboot.service;

import com.myth.springboot.dao.ClassCourseMapper;
import com.myth.springboot.entity.ClassCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassCourseService {
    @Autowired
    ClassCourseMapper mapper;

    //班级新增，查询，修改，删除
    public int ccInsert(ClassCourse classCourse){
        return mapper.ccInsert(classCourse);
    }
    public List<ClassCourse> ccSelect(ClassCourse classCourse){
        return mapper.ccSelect(classCourse);
    }
    public int ccUpdateById(ClassCourse classCourse){
        return mapper.ccUpdateById(classCourse);
    }
    public int ccDeleteById(ClassCourse classCourse){
        return mapper.ccDeleteById(classCourse);
    }






}

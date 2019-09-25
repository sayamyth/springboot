package com.myth.springboot.dao;

import com.myth.springboot.entity.ClassCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ClassCourseMapper {
    //新增课程
    int ccInsert(ClassCourse classCourse);
    //查询课程
    List<ClassCourse> ccSelect(ClassCourse classCourse);
    //修改课程
    int ccUpdateById(ClassCourse classCourse);
    //删除课程
    int ccDeleteById(ClassCourse classCourse);


}

package com.myth.springboot.dao;

import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CourseMapper {
    //新增课程
    int courseInsert(Course course);
    //查询课程
    List<Course> courseSelect(Course course);
    //修改课程
    int courseUpdateById(Course course);
    //删除课程
    int courseDeleteById(Course course);


}

package com.myth.springboot.dao;

import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface StudentMapper {

    int studentInsert(Student student);
    //查询学生集合可以附带条件
    List<Student> studentSelect(Student student);
    //更新学生
    int studentUpdateById(Student student);
    //删除学生
    int studentDeleteById(Student student);


    int studentDeleteByUserId(Student student);
    public List<Student> selectStudentByName(String s_name);




}

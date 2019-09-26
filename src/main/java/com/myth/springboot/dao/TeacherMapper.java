package com.myth.springboot.dao;

import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TeacherMapper {



    //查询教师详细信息
    List<Teacher> teacherSelect(Teacher teacher);
    //修改教师信息
    int teacherUpdate(Teacher teacher);
    //删除教师及用户信息
    int teacherDelete(Teacher teacher);
    int teacherDeleteByUserId(Teacher teacher);

    int teacherAdd(Teacher teacher);

}

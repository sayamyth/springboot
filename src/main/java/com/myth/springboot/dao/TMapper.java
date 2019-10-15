package com.myth.springboot.dao;

import com.myth.springboot.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TMapper {
   
    ResultTeacher selectTeacherByUname(String u_name);
    List<Teacher> selectTeachersByDeptId(String dept_id);
    List<Questions> selectTest();
    int insertMark(String teacher_id,String role_id, String time,String point);
    Tmark selectMark(String teacher_id, String role_id, String time);

    List<Teaching> getTeachingList(String user_name);
    List<Mark> getStudentPoint(String te_id);
    List<Tmark> selectTeacherPoint(String user_name,String time);
}

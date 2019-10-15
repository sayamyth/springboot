package com.myth.springboot.service;

import com.myth.springboot.dao.AdminMapper;
import com.myth.springboot.dao.TMapper;
import com.myth.springboot.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TService {
    @Autowired
    TMapper mapper;
    public ResultTeacher selectTeacherByUname(String u_name){
        return mapper.selectTeacherByUname(u_name);
    }
    public  List<Teacher> selectTeachersByDeptId(String dept_id){
        return mapper.selectTeachersByDeptId(dept_id);
    }
    public  List<Questions> selectTest(){
        return mapper.selectTest();
    }
    public int insertMark(String teacher_id,String role_id, String time ,String point){
        return mapper.insertMark(teacher_id,role_id,time,point);
    }
    public Tmark selectMark(String teacher_id, String role_id, String time){
        return mapper.selectMark(teacher_id,role_id,time);
    }

    public List<Teaching> getTeachingList(String user_name){
        return mapper.getTeachingList(user_name);
    }
    public  List<Mark> getStudentPoint(String te_id){
        return mapper.getStudentPoint(te_id);
    }
    public List<Tmark> selectTeacherPoint(String user_name,String time){
        return mapper.selectTeacherPoint(user_name,time);
    }
}

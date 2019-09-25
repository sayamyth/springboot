package com.myth.springboot.service;

import com.myth.springboot.entity.*;
import com.myth.springboot.entity.Class;
import com.myth.springboot.dao.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminMapper mapper;
    //查询用户带上可以附带条件
    public List<Student> studentAllSelect(Student student){
        return mapper.studentAllSelect(student);
    }
    public int studentUpdateById(Student student){
        return mapper.studentUpdateById(student);
    }
    public int studentDeleteById(Student student){
        return mapper.studentDeleteById(student);
    }
    //部门查询，修改，删除
    public List<Dept> deptSelectAll(){
        return mapper.deptSelectAll();
    }
    public int deptUpdateById(Dept dept){
        return mapper.deptUpdateById(dept);
    }
    public int deptDeleteById(Dept dept){
        return mapper.deptDeleteById(dept);
    }
    //班级查询，修改，删除
    public List<Class> classSelectAll(){
        return mapper.classSelectAll();
    }
    public int classUpdateById(Class cla){
        return mapper.classDeleteById(cla);
    }
    public int classDeleteById(Class cla){
        return mapper.classDeleteById(cla);
    }
    //用户的操作
   public int userDelete(User user){
        return mapper.userDelete(user);
   }




   //查询教师所有信息
    public List<Teacher> teacherSelectAll(Teacher teacher){
        return mapper.teacherSelectAll(teacher);
    }
    //修改教师信息
    public int teacherUpdate(Teacher teacher){
        return mapper.teacherUpdate(teacher);
    }
    //删除教师
    public int teacherDelete(Teacher teacher){
        return mapper.teacherDelete(teacher);
    }
}

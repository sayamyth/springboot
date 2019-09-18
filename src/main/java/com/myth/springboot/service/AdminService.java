package com.myth.springboot.service;

import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.Dept;
import com.myth.springboot.entity.Student;
import com.myth.springboot.entity.User;
import com.myth.springboot.mapper.AdminMapper;
import com.myth.springboot.mapper.LoginMapper;
import org.apache.ibatis.annotations.Param;
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

}

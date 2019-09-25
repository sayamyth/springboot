package com.myth.springboot.dao;

import com.myth.springboot.entity.*;
import com.myth.springboot.entity.Class;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface AdminMapper {
    //查询学生集合可以附带条件
    List<Student> studentAllSelect(Student student);
    //更新学生
    int studentUpdateById(Student student);
    //删除学生
    int studentDeleteById(Student student);
    //查询部门
    List<Dept> deptSelectAll();
    //修改部门
    int deptUpdateById(Dept dept);
    //删除部门
    int deptDeleteById(Dept dept);
    //查询班级
    List<Class> classSelectAll();
    //修改班级
    int classUpdateById(Class cla);
    //删除班级
    int classDeleteById(Class cla);
    //删除用户
    int userDelete(User user);


    //查询教师详细信息
    List<Teacher> teacherSelectAll(Teacher teacher);
    //修改教师信息
    int teacherUpdate(Teacher teacher);
    //删除教师及用户信息
    int teacherDelete(Teacher teacher);

}

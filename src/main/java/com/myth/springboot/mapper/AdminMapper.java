package com.myth.springboot.mapper;

import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.Dept;
import com.myth.springboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}

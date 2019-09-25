package com.myth.springboot.dao;

import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface DeptMapper {
    //新增部门
    int deptInsert(Dept dept);
    List<Dept> deptSelect(Dept dept);
    //修改部门
    int deptUpdateById(Dept dept);
    //删除部门
    int deptDeleteById(Dept dept);
    //查询班级
    List<Class> classSelectAll();
    //修改班级


}

package com.myth.springboot.dao;

import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ClassMapper {
    //新增班级
    int classInsert(Class cla);
    //查询班级
    List<Class> classSelect(Class cla);
    //修改班级
    int classUpdateById(Class cla);
    //删除班级
    int classDeleteById(Class cla);


}

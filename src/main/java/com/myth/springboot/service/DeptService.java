package com.myth.springboot.service;

import com.myth.springboot.dao.AdminMapper;
import com.myth.springboot.dao.DeptMapper;
import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    @Autowired
    DeptMapper mapper;

    //部门新增，查询，修改，删除
    public int classInsert(Dept dept){
        return mapper.deptInsert(dept);
    }
    public List<Dept> deptSelect(Dept dept){
        return mapper.deptSelect(dept);
    }
    public int deptUpdateById(Dept dept){
        return mapper.deptUpdateById(dept);
    }
    public int deptDeleteById(Dept dept){
        return mapper.deptDeleteById(dept);
    }

}

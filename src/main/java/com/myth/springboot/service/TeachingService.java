package com.myth.springboot.service;

import com.myth.springboot.dao.AdminMapper;
import com.myth.springboot.dao.TeacherMapper;
import com.myth.springboot.dao.TeachingMapper;
import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachingService {
    @Autowired
    TeachingMapper mapper;

    public int teachingAdd(Teaching teaching){
        return mapper.teachingInsert(teaching);
    }

    public List<Teaching> teachingSelect(Teaching teaching){
        return mapper.teachingSelect(teaching);
    }


    public int teachingDelete(Teaching teaching){
        return mapper.teachingDelete(teaching);
    }

    public String selectMarkByID(String te_id){
        return mapper.selectMarkByID(te_id);
    }

    public int updateTeaching(String mark,String te_id){
        return mapper.updateTeaching(mark,te_id);
    }

}

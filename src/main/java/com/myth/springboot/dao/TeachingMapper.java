package com.myth.springboot.dao;

import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TeachingMapper {
    int teachingInsert(Teaching teaching);
    List<Teaching> teachingSelect(Teaching teaching);
    int teachingDelete(Teaching teaching);

}

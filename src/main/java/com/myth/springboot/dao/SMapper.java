package com.myth.springboot.dao;

import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SMapper {
    Result selectByUid(String u_id);
    int insertMark(String te_id,String user_id,String point);
    List<Mark> selectMark(String user_id);
}

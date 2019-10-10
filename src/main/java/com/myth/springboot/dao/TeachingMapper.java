package com.myth.springboot.dao;

import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.*;
import org.apache.ibatis.annotations.Mapper;

import javax.websocket.server.PathParam;
import java.util.List;


@Mapper
public interface TeachingMapper {
    int teachingInsert(Teaching teaching);
    List<Teaching> teachingSelect(Teaching teaching);
    int teachingDelete(Teaching teaching);

    String selectMarkByID(String te_id);

    int updateTeaching(@PathParam("mark")String mark,@PathParam("te_id") String te_id);

}

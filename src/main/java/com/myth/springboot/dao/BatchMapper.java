package com.myth.springboot.dao;

import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BatchMapper {
    int batchInsert(Batch batch);

    List<Batch> batchSelect(Batch batch);

    int batchUpdate(Batch batch);
    int batchUpdateType(Batch batch);

    int batchDelete(Batch batch);

}

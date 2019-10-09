package com.myth.springboot.service;

import com.myth.springboot.dao.AdminMapper;
import com.myth.springboot.dao.BatchMapper;
import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchService {
    @Autowired
    BatchMapper mapper;


    public int batchInsert(Batch batch){
        return mapper.batchInsert(batch);
    }


    public List<Batch> batchSelect(Batch batch){
        return mapper.batchSelect(batch);
    }

    public int batchUpdate(Batch batch){
        return mapper.batchUpdate(batch);
    }
    public int batchUpdateType(Batch batch){
        return mapper.batchUpdateType(batch);
    }
    public int batchDelete(Batch batch){
        return mapper.batchDelete(batch);
    }
}

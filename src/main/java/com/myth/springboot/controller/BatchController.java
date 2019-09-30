package com.myth.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.springboot.entity.Batch;
import com.myth.springboot.entity.Msg;
import com.myth.springboot.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BatchController {
    @Autowired
    BatchService batchService;

    @RequestMapping("/batchList")
    @ResponseBody
    public Msg batchList(){
        List<Batch> batches = batchService.batchSelect(new Batch());
        return Msg.success().add("data",batches);
    }

    @RequestMapping("/batchListWithPage")
    @ResponseBody
    public Map batchListWithPage(String page,String limit){
        PageHelper.startPage(Integer.valueOf(page).intValue(),Integer.valueOf(limit).intValue());
        List<Batch> batches = batchService.batchSelect(new Batch());
        PageInfo pageInfo = new PageInfo(batches,5);
        Map<String,Object> map = new HashMap<>();
        map.put("data",pageInfo);
        return map;
    }
}

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
import org.springframework.web.servlet.ModelAndView;

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
        return Msg.success().add("batch",batches);
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

    @RequestMapping("/batchAdd")
    @ResponseBody
    public Msg batchAdd(String name){
        Batch batch = new Batch();
        List<Batch> batches = batchService.batchSelect(new Batch());
        for (Batch b:batches){
            if (b.getB_name().equals(name)){
                return Msg.success().add("msg","该批次已存在！");
            }
        }
        batch.setB_name(name);
        int i  = batchService.batchInsert(batch);
        if (i>0){
            return Msg.success().add("msg","批次信息添加成功！");
        }else {
            return Msg.success().add("msg","批次信息添加失败！");
        }
    }



    /***
     * 修改功能
     */
    @RequestMapping("/batchGetById")
    public ModelAndView batchGetById(String id){
        Batch batch = new Batch();
        batch.setB_id(Integer.valueOf(id).intValue());
        ModelAndView mv= new ModelAndView("batch/batch-update");
        //batchService.batchSelect(batch).get(0);
        return mv.addObject("batch",batchService.batchSelect(batch).get(0));
    }


    @RequestMapping("/batchUpdate")
    @ResponseBody
    public Msg batchUpdate(String id,String name){
        Batch batch = new Batch(Integer.valueOf(id).intValue(),name);
        List<Batch> batches = batchService.batchSelect(new Batch());
        for (Batch b:batches){
            if (b.getB_name().equals(name)){
                return Msg.success().add("msg","该批次已存在！");
            }
        }
        int i = batchService.batchUpdate(batch);
        if (i>0){
            return Msg.success().add("msg","修改成功！");
        }else {
            return Msg.success().add("msg","修改失败！");
        }
    }


    /***
     * 删除
     */
    @RequestMapping("/batchDelete")
    @ResponseBody
    public Msg batchDelete(String id){
        Batch batch = new Batch(Integer.valueOf(id));

        int i = batchService.batchDelete(batch);
        if (i>0){
            return Msg.success().add("msg","删除成功！");
        }else {
            return Msg.success().add("msg","删除失败！");
        }
    }
    /***
     * 修改开启关闭状态
     */
    @RequestMapping("/batchChangeTrue")
    @ResponseBody
    public Msg batchChangeTrue(String id){
        Batch batch = new Batch();
        batch.setB_id(Integer.valueOf(id).intValue());
        batch.setB_type("1");
        int i = batchService.batchUpdateType(batch);
        if (i>0){
            System.out.println("--------已开启------");
            return Msg.success().add("msg","ok");
        }else {
            return Msg.success().add("msg","fail");
        }
    }

    @RequestMapping("/batchChangeFalse")
    @ResponseBody
    public Msg batchChangeFalse(String id){
        System.out.println(id);
        Batch batch = new Batch();
        batch.setB_id(Integer.valueOf(id).intValue());
        batch.setB_type("0");
        int i = batchService.batchUpdateType(batch);
        if (i>0){
            System.out.println("--------已关闭------");
            return Msg.success().add("msg","ok");
        }else {
            return Msg.success().add("msg","fail");
        }
    }
}

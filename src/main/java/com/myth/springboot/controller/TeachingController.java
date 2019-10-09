package com.myth.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.springboot.entity.Batch;
import com.myth.springboot.entity.Msg;
import com.myth.springboot.entity.Teaching;
import com.myth.springboot.service.BatchService;
import com.myth.springboot.service.TeachingService;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TeachingController {
    @Autowired
    TeachingService teachingService;
    @Autowired
    BatchService batchService;
    @RequestMapping("/teachingAdd")
    @ResponseBody
    public Msg teachingAdd(String batch,String cla,String dept_id,String dept_name,String teacher,String course){
        String batchArr[];
        String claArr[];
        String teacherArr[];
        String courseArr[];
        batchArr = batch.split("-");
        claArr = cla.split("-");
        teacherArr = teacher.split("-");
        courseArr = course.split("-");
        if (teacher.equals("")){
            return Msg.success().add("msg","教师信息不能为空！");
        }
        List<Teaching> teachings = teachingService.teachingSelect(new Teaching());

        for (Teaching t:teachings){
//            System.out.println(t.getClass_name()+t.getTeacher_name()+t.getCourse_name());

            if (t.getClass_name().equals(claArr[1]) && t.getTeacher_name().equals(teacherArr[1]) && t.getCourse_name().equals(courseArr[1]) ){
                System.out.println("jiesu");
                return Msg.success().add("msg","已有此课程纪录！");

            }
            if(t.getClass_name().equals(claArr[1]) && t.getCourse_name().equals(courseArr[1])){
                return Msg.success().add("msg","已有老师上课！");
            }
            if (t.getClass_name().equals(claArr[1])){
                if(t.getIs_end().equals("0")){
                    return Msg.success().add("msg","此班级还没结业！");
                }
            }

        }
        Teaching teaching = new Teaching(batchArr[0],batchArr[1],claArr[0],claArr[1],dept_id,dept_name,teacherArr[0],teacherArr[1],courseArr[0],courseArr[1]);
        int i = teachingService.teachingAdd(teaching);
        if (i>0){
            return Msg.success().add("msg","信息添加成功！");
        }else {
            return Msg.success().add("msg","信息添加失败！");
        }
    }

    @RequestMapping("/teachingListWithPage")
    @ResponseBody
    public Map teachingListWithPage(String page,String limit){
        PageHelper.startPage(Integer.valueOf(page).intValue(),Integer.valueOf(limit).intValue());
        List<Teaching> teachings = teachingService.teachingSelect(new Teaching());
        PageInfo pageInfo = new PageInfo(teachings,5);
        Map<String, Object> map = new HashMap<>();
        map.put("data",pageInfo);
        return map;
    }



    @RequestMapping("/teachingDelete")
    @ResponseBody
    public Msg teachingDelete(String id){
        int i = teachingService.teachingDelete(new Teaching(Integer.valueOf(id).intValue()));
        if (i>0){
            return Msg.success().add("msg","删除成功！");
        }else {
            return Msg.success().add("msg","删除失败！");
        }
    }

    @RequestMapping("/teachingDeleteMany")
    @ResponseBody
    public Msg teachingDeleteMany(String id){
        String str[] = id.split(",");
        String s="";
        for (int i = 0; i<str.length;i++){
            int j = teachingService.teachingDelete(new Teaching(Integer.valueOf(str[i]).intValue()));
            if (j>0){
               s+=str[i]+"删除成功！";
            }else {
                s+=str[i]+"删除失败！";
            }
        }
       return Msg.success().add("msg",s);
    }


    //统计分数
    @RequestMapping("/getMark")
    @ResponseBody
    public Msg getMark(String id,String batch_name,String class_name){
        Batch batch = new Batch();
        batch.setB_name(batch_name);
        String type=batchService.batchSelect(batch).get(0).getB_type();
//        System.out.println(type);
        if (type.equals("1")){
            return Msg.success().add("msg","批次尚未关闭！");
        }


        //写统分逻辑，此处未完成
        return Msg.success().add("msg","sss");
    }

}

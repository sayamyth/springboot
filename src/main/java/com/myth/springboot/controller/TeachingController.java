package com.myth.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.springboot.entity.Msg;
import com.myth.springboot.entity.Teaching;
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
    @RequestMapping("/teachingAdd")
    @ResponseBody
    public Msg teachingAdd(String class_name,String dept_name,String teacher_name,String course_name){
        if (teacher_name.equals("")){
            return Msg.success().add("msg","教师信息不能为空！");
        }
        List<Teaching> teachings = teachingService.teachingSelect(new Teaching());

        for (Teaching t:teachings){
//            System.out.println(t.getClass_name()+t.getTeacher_name()+t.getCourse_name());

            if (t.getClass_name().equals(class_name) && t.getTeacher_name().equals(teacher_name) && t.getCourse_name().equals(course_name) ){
                System.out.println("jiesu");
                return Msg.success().add("msg","已有此纪录！");

            }
        }
        Teaching teaching = new Teaching(class_name,dept_name,teacher_name,course_name);
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

}

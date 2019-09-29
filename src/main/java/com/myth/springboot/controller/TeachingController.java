package com.myth.springboot.controller;

import com.myth.springboot.entity.Msg;
import com.myth.springboot.entity.Teaching;
import com.myth.springboot.service.TeachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
}

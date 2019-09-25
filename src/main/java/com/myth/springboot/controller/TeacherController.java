package com.myth.springboot.controller;

import ch.qos.logback.core.pattern.color.MagentaCompositeConverter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.springboot.entity.Msg;
import com.myth.springboot.entity.Teacher;
import com.myth.springboot.entity.User;
import com.myth.springboot.service.TeacherService;
import com.myth.springboot.service.UserService;
import jdk.nashorn.internal.runtime.FindProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    UserService userService;

    /**
     * 教师业务
     */
    @RequestMapping("/teacherListWithPage")
    @ResponseBody
    public Map teacherList(String page, String limit){
        PageHelper.startPage(Integer.valueOf(page).intValue(), Integer.valueOf(limit).intValue());
        Teacher t=new Teacher();
        List<Teacher> teacher = teacherService.teacherSelect(t);
        for (int i = 0;i<teacher.size();i++){
            teacher.get(i).setDept_name(teacher.get(i).getDept().getD_name());
        }
        PageInfo pageInfo = new PageInfo(teacher,5);
        Map<String,Object> map = new HashMap<>();
        map.put("data",pageInfo);

        return map;
    }
    @RequestMapping("/teacherGetById")
    @ResponseBody
    public ModelAndView teacherGetById(String id){
        ModelAndView mv= new ModelAndView("teacher-update");
        Integer t_id = Integer.valueOf(id).intValue();
        Teacher teacher = new Teacher();
        teacher.setT_id(t_id);
        List<Teacher> t = teacherService.teacherSelect(teacher);
        Teacher tt = t.get(0);
        mv.addObject("teacher",tt);
        return mv;
    }
    @RequestMapping("/teacherUpdate")
    @ResponseBody
    public Msg teacherUpdate(String id,String name,String sex,String d_name){
        Integer t_id=Integer.valueOf(id).intValue();
        String dept_id;
        String arr[] = d_name.split("-");
        dept_id=arr[0];
        Teacher teacher = new Teacher(t_id,name,sex,dept_id);
        int i=teacherService.teacherUpdate(teacher);
        if (i>0){
            return Msg.success().add("msg","修改成功");
        }else {
            return Msg.success().add("msg","老弟不知道怎么费事，出错啦！");
        }
    }
    /*
    删除教师信息以及用户
     */
    @RequestMapping("/teacherDelete")
    @ResponseBody
    public Msg teacherDelete(String id){
        Integer t_id;

        t_id = Integer.valueOf(id).intValue();

        Teacher teacher= new Teacher();
        teacher.setT_id(t_id);

            int i=teacherService.teacherDelete(teacher);
            if (i>0){
                return Msg.success().add("msg","教师详情删除成功");
            }else {
                return Msg.success().add("msg","教师详情删除失败");
            }


    }


    @RequestMapping("/teacherDeleteMany")
    @ResponseBody
    public Msg teacherDeleteMany(String id){
        String str[] = id.split(",");

        String s="";
        for (int i = 0;i<str.length;i++){

            int t_id = Integer.valueOf(str[i]).intValue();
            Teacher teacher= new Teacher();
            teacher.setT_id(t_id);
            int j=teacherService.teacherDelete(teacher);
            if (j > 0) {
                s+=str[i]+"学生详情删除成功";
            } else {
                s+=str[i]+"学生详情删除失败";
            }
        }
         return Msg.success().add("msg",s);
    }

}

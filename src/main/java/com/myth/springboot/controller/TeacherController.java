package com.myth.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.springboot.entity.*;
import com.myth.springboot.service.TeacherService;
import com.myth.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    UserService userService;


    /**
     * 教师业务
     */

    //根据name查找用户
    @RequestMapping("/selectTeacherByName")
    @ResponseBody
    public Map selectTeacherByName(String t_name){
        PageHelper.startPage(1,10);
        Teacher teacher=new Teacher();
        teacher.setT_name(t_name);
        List<Teacher> list=teacherService.selectTeacherByName(t_name);
        PageInfo pageInfo = new PageInfo(list,5);
        Map<String,Object> map = new HashMap<>();
        map.put("data",pageInfo);
        return map;
    }



    @RequestMapping("/teacherSelectByDeptId")
    @ResponseBody
    public Map teacherSelectByDeptId(String dept_id){
        Teacher teacher = new Teacher();

        teacher.setDept_id(dept_id);
        List<Teacher> t = teacherService.teacherSelect(teacher);
        Map<String,Object> map = new HashMap<>();
        map.put("teacher",t);
        return map;
    }


    @RequestMapping("/teacherAdd")
    @ResponseBody
    public Msg teacherAdd(@PathParam("user_name") String user_name, @PathParam("t_name")String t_name, @PathParam("sex")String sex, @PathParam("d_id")String d_id){


        List<User> users = userService.userSelect(new User(user_name));
        if (users.isEmpty()) {
            return Msg.success().add("msg", "无此用户！");
        }



        List<Teacher> t=teacherService.teacherSelect(new Teacher(user_name));
        if (!t.isEmpty()){
                return Msg.success().add("msg","已有该教师信息！！！");
        }
        Teacher teacher = new Teacher(user_name,t_name,sex,d_id);
        int i= teacherService.teacherAdd(teacher);
        if (i>0){
            return Msg.success().add("msg","教师信息添加成功！！！");
        }else {
            return Msg.success().add("msg","教师信息添加失败！！！");
        }

    }

    @RequestMapping("/teacherListWithPage")
    @ResponseBody
    public Map teacherList(String page, String limit){
        PageHelper.startPage(Integer.valueOf(page).intValue(), Integer.valueOf(limit).intValue());
        Teacher t=new Teacher();
        List<Teacher> teacher = teacherService.teacherSelect(t);

        PageInfo pageInfo = new PageInfo(teacher,5);
        Map<String,Object> map = new HashMap<>();
        map.put("data",pageInfo);

        return map;
    }
    @RequestMapping("/teacherGetById")
    @ResponseBody
    public ModelAndView teacherGetById(String id){
        ModelAndView mv= new ModelAndView("teacher/teacher-update");
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
    public Msg teacherUpdate(String id,String name,String sex,String d_id){
        Integer t_id=Integer.valueOf(id).intValue();

        Teacher teacher = new Teacher(t_id,name,sex,d_id);
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
                s+=str[i]+"教师详情删除成功";
            } else {
                s+=str[i]+"教师详情删除失败";
            }
        }
         return Msg.success().add("msg",s);
    }

}

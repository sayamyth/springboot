package com.myth.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.springboot.entity.Class;
import com.myth.springboot.entity.Dept;
import com.myth.springboot.entity.Msg;
import com.myth.springboot.entity.Student;
import com.myth.springboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;


    /*
    学生业务
     */
    @RequestMapping("/studentList")
    public ModelAndView studentList() {
        ModelAndView mv = new ModelAndView("student-list");
        Student s = new Student();
        List<Student> student = adminService.studentAllSelect(s);
        mv.addObject("students", student);
        return mv;
    }
    /*
        得到当前id的学生的所有信息
     */
    @RequestMapping("/studentGetById")
    public ModelAndView studentGetById(String id) {
        ModelAndView mv = new ModelAndView("student-update");
        Student s = new Student();
        int s_id = Integer.valueOf(id).intValue();
        s.setS_id(s_id);
        List<Student> student = adminService.studentAllSelect(s);
        Student ss = student.get(0);
        mv.addObject("student", ss);
        return mv;
    }
    /*
        修改学生信息
     */
    @RequestMapping("/studentUpdate")
    @ResponseBody
    public String studentUpdate(String id,String name,String sex,String c_name,String d_name){
        Integer s_id=Integer.valueOf(id).intValue();
        String sex_id;
        String c_id;
        String d_id;
        String str[] = c_name.split("-");
        String str1[] = d_name.split("-");
        c_id=str[0];
        d_id=str1[0];
        if (sex.equals("男")){
            sex_id="1";
        }else {
            sex_id="0";
        }
        Student student = new Student(s_id,name,sex_id,c_id,d_id);
        int i=adminService.studentUpdateById(student);
        if (i>0){
            return "修改成功";
        }else {
            return "老弟不知道怎么费事，出错啦！";
        }

    }
    /**
     * 班级业务
     */
    /*
        得到所有class信息
     */
    @RequestMapping("/classList")
    @ResponseBody
    public Msg classList(){
        List<Class> cla = adminService.classSelectAll();
        return Msg.success().add("cla",cla);
    }
    @RequestMapping("/classUpdate")
    @ResponseBody
    public Msg classUpdate(String id,String name){
        Integer c_id=Integer.valueOf(id).intValue();
        String c_name=name;
        Class cla = new Class(c_id,c_name);
        int i = adminService.classUpdateById(cla);
        if (i>0){
            return Msg.success().add("msg","修改成功,老弟！");
        }else {
            return Msg.fail().add("msg","出错了，老弟！");
        }
    }
    @RequestMapping("/classDelete")
    @ResponseBody
    public Msg classDelete(String id){
        Integer c_id=Integer.valueOf(id).intValue();
        Class cla = new Class(c_id);
        int i = adminService.classDeleteById(cla);
        if (i>0){
            return Msg.success().add("msg","修改成功,老弟！");
        }else {
            return Msg.fail().add("msg","出错了，老弟！");
        }
    }

    /**
     *院系业务
     */
    @RequestMapping("/deptList")
    @ResponseBody
    public Msg deptList(){
        List<Dept> depts = adminService.deptSelectAll();
        return Msg.success().add("dept",depts);
    }
}

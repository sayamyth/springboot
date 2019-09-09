package com.myth.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.springboot.entity.Msg;
import com.myth.springboot.entity.Student;
import com.myth.springboot.entity.User;
import com.myth.springboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
//@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("/hello")
    @ResponseBody
    public List<Student> hello(){
        return adminService.selectStudentWithDept();
    }
    @RequestMapping("/studentAdd")
    public String index(){
        return "studentAdd";
    }
 //   @RequestMapping("/selectUserWithType")
//    public String select(String type){
//        List<User> users=adminService.selectUser(type);
//        return "index";
//    }
    //学生列表
    @RequestMapping("/studentList")
    public String studentList(){
        return "student-list";
    }
    @RequestMapping("/selectStudent")
    @ResponseBody
    public List<Student> selectStudent(){
        return adminService.selectStudentWithClass();
    }

    @RequestMapping("/emps")
    @ResponseBody
    public Msg emps(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,10);
        List<Student> list = adminService.selectStudentWithClass();
        PageInfo page = new PageInfo(list,5);
        return Msg.success().add("page",page).add("list",list);
    }
}

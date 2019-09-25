package com.myth.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.springboot.entity.Msg;
import com.myth.springboot.entity.Student;
import com.myth.springboot.entity.User;
import com.myth.springboot.service.StudentService;
import com.myth.springboot.service.UserService;
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
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    UserService userService;

    /**
     * 学生业务
     *
     * @return
     */
    @RequestMapping("/studentList")
    @ResponseBody
    public Msg studentList() {
        Student s = new Student();
        List<Student> students = studentService.studentSelect(s);
        //mv.addObject("students", student);







        return Msg.success().add("student", students);
    }
    @RequestMapping("/studentListWithPage")
    @ResponseBody
    public Map studentList(String page, String limit) {
        PageHelper.startPage(Integer.valueOf(page).intValue(), Integer.valueOf(limit).intValue());
        Student s = new Student();
        List<Student> student = studentService.studentSelect(s);
        for (int i = 0;i<student.size();i++){
            student.get(i).setClass_name(student.get(i).getCla().getC_name());
            student.get(i).setDept_name(student.get(i).getDept().getD_name());
        }
        PageInfo pageInfo = new PageInfo(student, 5);
        //mv.addObject("students", student);
        Map<String,Object> map = new HashMap<>();
        map.put("data",pageInfo);





        return map;
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
        List<Student> student = studentService.studentSelect(s);
        Student ss = student.get(0);
        mv.addObject("student", ss);
        return mv;
    }

    /*
        修改学生信息
     */
    @RequestMapping("/studentUpdate")
    @ResponseBody
    public Msg studentUpdate(String id, String name, String sex, String c_name, String d_name) {
        Integer s_id = Integer.valueOf(id).intValue();
        String c_id;
        String d_id;
        String str[] = c_name.split("-");
        String str1[] = d_name.split("-");
        c_id = str[0];
        d_id = str1[0];
        Student student = new Student(s_id, name, sex, c_id, d_id);
        int i = studentService.studentUpdateById(student);
        if (i > 0) {
            return Msg.success().add("msg","学生信息修改成功");
        } else {
            return Msg.success().add("msg","学生信息修改失败！！！！");
        }
    }

    /*
        通过id删除学生
     */
    @RequestMapping("/studentDelete")
    @ResponseBody
    public Msg studentDelete(String id) {
        //System.out.println(id1);
        Integer s_id;

        s_id = Integer.valueOf(id).intValue();
        Student student = new Student();
        student.setS_id(s_id);
        int i = studentService.studentDeleteById(student);
        if (i > 0) {
            return Msg.success().add("msg","学生详情删除成功");
        } else {
                return Msg.success().add("msg","学生详情删除失败");
        }
    }
    @RequestMapping("/studentDeleteMany")
    @ResponseBody
    public Msg studentDeleteMany(String id) {
        String str[] = id.split(",");

        String s="";


        for (int i = 0;i<str.length;i++){
            Integer s_id = Integer.valueOf(str[i]).intValue();
            Student student = new Student();
            student.setS_id(s_id);
            int j = studentService.studentDeleteById(student);
            if (j > 0) {
               s+=str[i]+"学生详情删除成功";
            } else {
                s+=str[i]+"学生详情删除失败";
            }
        }


        return Msg.success().add("msg",s);
    }
}
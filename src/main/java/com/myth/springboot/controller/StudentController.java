package com.myth.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.springboot.entity.Msg;
import com.myth.springboot.entity.Student;
import com.myth.springboot.entity.Teacher;
import com.myth.springboot.entity.User;
import com.myth.springboot.service.StudentService;
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
    @RequestMapping("/selectStudentByName")
    @ResponseBody
    public Map selectStudentByName(String s_name){
        PageHelper.startPage(1,10);
        Student student=new Student();
        student.setS_name(s_name);
        List<Student> list=studentService.selectStudentByName(s_name);
        PageInfo pageInfo = new PageInfo(list,5);
        Map<String,Object> map = new HashMap<>();
        map.put("data",pageInfo);
        return map;
    }

    @RequestMapping("/studentAdd")
    @ResponseBody
    public Msg studentAdd(@PathParam("user_id") String user_id, @PathParam("name") String name, @PathParam("sex") String sex, @PathParam("c_id") String c_id) {

        List<Student> students = studentService.studentSelect(new Student(user_id));

        if (!students.isEmpty()) {
            return Msg.success().add("msg", "该生信息已存在！！！");
        }

        List<User> users = userService.userSelect(new User(Integer.valueOf(user_id).intValue()));
        if (users.isEmpty()) {
            return Msg.success().add("msg", "无此用户！");
        }
        if (users.get(0).getType_id().equals("3")) {
            Student student = new Student(user_id, name, sex, c_id);
            int i = studentService.studentInsert(student);
            if (i > 0) {
                return Msg.success().add("msg", "添加学生详情成功");
            } else {
                return Msg.success().add("msg", "添加学生详情失败");
            }
        } else {
            return Msg.success().add("msg", "权限和信息不匹配！");
        }

    }

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

        PageInfo pageInfo = new PageInfo(student, 5);
        //mv.addObject("students", student);
        Map<String, Object> map = new HashMap<>();
        map.put("data", pageInfo);


        return map;
    }

    /*
        得到当前id的学生的所有信息
     */
    @RequestMapping("/studentGetById")
    public ModelAndView studentGetById(String id) {
        ModelAndView mv = new ModelAndView("student/student-update");
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
    public Msg studentUpdate(String id, String name, String sex, String c_id) {
        Integer s_id = Integer.valueOf(id).intValue();
        Student student = new Student(s_id, name, sex, c_id);
        int i = studentService.studentUpdateById(student);
        if (i > 0) {
            return Msg.success().add("msg", "学生信息修改成功");
        } else {
            return Msg.success().add("msg", "学生信息修改失败！！！！");
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
            return Msg.success().add("msg", "学生详情删除成功");
        } else {
            return Msg.success().add("msg", "学生详情删除失败");
        }
    }

    @RequestMapping("/studentDeleteMany")
    @ResponseBody
    public Msg studentDeleteMany(String id) {
        String str[] = id.split(",");

        String s = "";


        for (int i = 0; i < str.length; i++) {
            Integer s_id = Integer.valueOf(str[i]).intValue();
            Student student = new Student();
            student.setS_id(s_id);
            int j = studentService.studentDeleteById(student);
            if (j > 0) {
                s += str[i] + "学生详情删除成功";
            } else {
                s += str[i] + "学生详情删除失败";
            }
        }


        return Msg.success().add("msg", s);
    }
}
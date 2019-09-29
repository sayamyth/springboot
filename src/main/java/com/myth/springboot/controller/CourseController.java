package com.myth.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.springboot.entity.*;
import com.myth.springboot.service.CourseService;
import com.myth.springboot.service.StudentService;
import com.myth.springboot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    /**
     * 班级业务
     */
    /*
        得到所有class信息
     */
    @RequestMapping("/courseAdd")
    @ResponseBody
    public Msg courseInsert(String name){
        Course course = new Course();
        course.setCo_name(name);

        List<Course> c = courseService.courseSelect(new Course());
        for (Course cc:c){
            System.out.println(cc.getCo_name());
            if (cc.getCo_name().equals(name)){
                return Msg.success().add("msg","请勿重复添加课程！！！");
            }
        }
        int i = courseService.courseInsert(course);
        if (i>0){
            return Msg.success().add("msg","课程新增成功");
        }else {
            return Msg.success().add("msg","课程新增失败");
        }
    }

    @RequestMapping("/courseListWithPage")
    @ResponseBody
    public Map<String, Object> courseListWithPage(String page,String limit){
        PageHelper.startPage(Integer.valueOf(page).intValue(),Integer.valueOf(limit).intValue());
        List<Course> courses = courseService.courseSelect(new Course());
        PageInfo pageInfo = new PageInfo(courses,5);

        Map<String,Object> map = new HashMap<>();
        map.put("data",pageInfo);
        return map;
    }
    @RequestMapping("/courseList")
    @ResponseBody
    public Msg courseList(){
        List<Course> courses = courseService.courseSelect(new Course());

        return Msg.success().add("courses",courses);
    }
    @RequestMapping("/courseGetById")
    @ResponseBody
    public ModelAndView classGetById(String id){
        ModelAndView mv = new ModelAndView("course/course-update");
        Integer co_id= Integer.valueOf(id).intValue();
        Course course = new Course();
        course.setCo_id(co_id);
        List<Course> courses = courseService.courseSelect(course);
        mv.addObject("course",courses.get(0));
        return mv;
    }
    @RequestMapping("/courseUpdate")
    @ResponseBody
    public Msg classUpdate(String id,String name){

        Integer co_id=Integer.valueOf(id).intValue();
        String co_name=name;
        Course course = new Course(co_id,co_name);
        List<Course> c = courseService.courseSelect(new Course());
        for (Course cc:c){
            System.out.println(cc.getCo_name());
            if (cc.getCo_name().equals(name)){
                return Msg.success().add("msg","已有该课程，请勿修改！！！");
            }
        }
        int i = courseService.courseUpdateById(course);
        if (i>0){
            return Msg.success().add("msg","修改成功,老弟！");
        }else {
            return Msg.success().add("msg","出错了，老弟！");
        }
    }
    @RequestMapping("/courseDelete")
    @ResponseBody
    public Msg classDelete(String id){
        Course course = new Course();
        course.setCo_id(Integer.valueOf(id).intValue());
        int i = courseService.courseDeleteById(course);
        if (i>0){
            return Msg.success().add("msg","删除课程成功");
        }else {
            return Msg.success().add("msg","删除课程失败");
        }

    }
    @RequestMapping("/courseDeleteMany")
    @ResponseBody
    public Msg courseDeleteMany(String id){
        String str[] = id.split(",");
        String s="";
        for (int i=0;i<str.length;i++){
            Course course = new Course();
            course.setCo_id(Integer.valueOf(str[i]).intValue());
            int j = courseService.courseDeleteById(course);
            if (j>0){
                s+=str[i]+"删除课程成功";
            }else {
                s+=str[i]+"删除课程失败";
            }
        }

        return Msg.success().add("msg",s);
    }
}

package com.myth.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.springboot.entity.*;
import com.myth.springboot.service.ClassCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClassCourseController {
    @Autowired
    ClassCourseService classCourseService;

    /**
     * 班级业务
     */
    /*
        得到所有class信息
     */
    @RequestMapping("/class_courseList")
    @ResponseBody
    public Msg classList() {

        List<ClassCourse> classCourses = classCourseService.ccSelect(new ClassCourse());

        return Msg.success().add("cc", classCourses);
    }

    @RequestMapping("/class_courseListWithPage")
    @ResponseBody
    public Msg classListWithPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10);
        List<ClassCourse> classCourses = classCourseService.ccSelect(new ClassCourse());
        PageInfo pageInfo = new PageInfo(classCourses, 5);
        return Msg.success().add("page", pageInfo);
    }

    @RequestMapping("/class_courseGetById")
    @ResponseBody
    public ModelAndView classGetById(String id) {
        ModelAndView mv = new ModelAndView("class-course-update");
        ClassCourse classCourse = new ClassCourse();
        classCourse.setId(Integer.valueOf(id).intValue());

        List<ClassCourse> classCourses = classCourseService.ccSelect(classCourse);
        mv.addObject("cc", classCourses.get(0));
        return mv;
    }

    @RequestMapping("/class_courseUpdate")
    @ResponseBody
    public Msg classUpdate(String id, String c_name,String d_name) {
        Integer.valueOf(id).intValue();
        String str1[] = c_name.split("-");
        String id1=str1[0];
        String str2[] = d_name.split("-");
        String id2 = str2[0];

        ClassCourse classCourse=new ClassCourse(Integer.valueOf(id).intValue(),id1,id2);
        int i = classCourseService.ccUpdateById(classCourse);
        if (i > 0) {
            return Msg.success().add("msg", "修改成功,老弟！");
        } else {
            return Msg.success().add("msg", "出错了，老弟！");
        }
    }

    @RequestMapping("/class_courseDelete")
    @ResponseBody
    public Msg classDelete(String id) {
//        System.out.println(id);

        ClassCourse classCourse=new ClassCourse();
        classCourse.setId(Integer.valueOf(id).intValue());
        int i=classCourseService.ccDeleteById(classCourse);
        if (i > 0) {
            return Msg.success().add("msg", "删除成功,老弟！");
        } else {
            return Msg.success().add("msg", "出错了，老弟！");
        }
    }
}
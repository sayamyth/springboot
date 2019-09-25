package com.myth.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JumpController {
    //页面跳转-----------------------------------------------------------------
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/a")
    public String a(){
        return "aaa";
    }

    @RequestMapping("/studentUpdata")
    public String studentUpdata(){
        return "student-update";
    }


    @RequestMapping("/toStudentList")
    public String toStudentList(){
        return "student-list";
    }
    @RequestMapping("/toStudentAdd")
    public String toStudentAdd(){
        return "student-add";
    }

    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
    @RequestMapping("/toTeacherList")
    public String toTeacherList(){
        return "teacher-list";
    }

    @RequestMapping("/toWelcome")
    public String toWelcome(){
        return "welcome";
    }

    @RequestMapping("/toClassList")
    public String toClassList(){
        return "class-list";
    }

    @RequestMapping("/toClassAdd")
    public String toClassAdd(){
        return "class-add";
    }
    @RequestMapping("/tcCourseList")
    public String tcCourseList(){
        return "course-list";
    }
    @RequestMapping("/toClassCourseList")
    public String toClassCourseList(){
        return "class-course-list";
    }

    @RequestMapping("/toDeptList")
    public String toDeptList(){
        return "dept-list";
    }
    @RequestMapping("toDeptAdd")
    public String toDeptAdd(){
        return "dept-add";
    }

    @RequestMapping("/toUserList")
    public String toUserList(){
        return "user/user-list";
    }
    @RequestMapping("/toUserAdd")
    public String toUserAdd(){
        return "user/user-add";
    }

}

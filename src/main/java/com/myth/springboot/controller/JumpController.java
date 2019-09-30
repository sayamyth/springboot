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



    //
    @RequestMapping("/toStudentList")
    public String toStudentList(){
        return "student/student-list";
    }
    @RequestMapping("/toStudentAdd")
    public String toStudentAdd(){
        return "student/student-add";
    }

    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
    //
    @RequestMapping("/toTeacherList")
    public String toTeacherList(){
        return "teacher/teacher-list";
    }
    @RequestMapping("/toTeacherAdd")
    public String toTeacherAdd(){
        return "teacher/teacher-add";
    }
    @RequestMapping("/toWelcome")
    public String toWelcome(){
        return "welcome";
    }


    //
    @RequestMapping("/toClassList")
    public String toClassList(){
        return "class/class-list";
    }

    @RequestMapping("/toClassAdd")
    public String toClassAdd(){
        return "class/class-add";
    }




    //
    @RequestMapping("/tcCourseList")
    public String tcCourseList(){
        return "course/course-list";
    }
    @RequestMapping("/tcCourseAdd")
    public String tcCourseAdd(){
        return "course/course-add";
    }


    //
    @RequestMapping("/toDeptList")
    public String toDeptList(){
        return "dept/dept-list";
    }
    @RequestMapping("toDeptAdd")
    public String toDeptAdd(){
        return "dept/dept-add";
    }


    //

    @RequestMapping("/toUserList")
    public String toUserList(){
        return "user/user-list";
    }
    @RequestMapping("/toUserAdd")
    public String toUserAdd(){
        return "user/user-add";
    }


    //
    @RequestMapping("/toTypeList")
    public String toTypeList(){
        return "type/type-list";
    }
    @RequestMapping("/toTypeAdd")
    public String toTypeAdd(){
        return "type/type-add";
    }

    //
    @RequestMapping("/toTeachingList")
    public String toTeachingList(){
        return "teaching/teaching-list";
    }
    @RequestMapping("/toTeachingAdd")
    public String toTeachingAdd(){
        return "teaching/teaching-add";
    }

    //

    @RequestMapping("/toBatchList")
    public String toBatchList(){
        return "batch/batch-list";
    }
}

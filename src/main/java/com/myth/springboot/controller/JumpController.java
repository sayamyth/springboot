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

    @RequestMapping("/studentUpdata")
    public String studentUpdata(){
        return "student-update";
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
}

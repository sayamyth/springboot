package com.myth.springboot.controller;

import com.myth.springboot.entity.User;
import com.myth.springboot.service.LoginService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.ibatis.annotations.Mapper;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/loginIn")
    public ModelAndView login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv;
        User u = loginService.login(username);
        System.out.println(BCrypt.checkpw(password,u.getU_password()));

        System.out.println(u.getType_id());
        try {
            if (u != null){
                if (BCrypt.checkpw(password,u.getU_password())){
                    if (u.getType_id().equals("1")){
                        System.out.println("进入1");
                        mv = new ModelAndView("index");
                        HttpSession session = request.getSession();
                        session.setAttribute("user",u.getU_name());
                        session.setAttribute("u_id",u.getU_id());
                        session.setMaxInactiveInterval(300);
                        mv.addObject("user",u);
                    }
                    else if (u.getType_id().equals("2")){
                        System.out.println("进入2");
                        mv = new ModelAndView("teacher");
                        HttpSession session = request.getSession();
                        session.setAttribute("user",u.getU_name());
                        session.setAttribute("u_id",u.getU_id());
                        mv.addObject("user",u);
                    }
                    else if (u.getType_id().equals("3")){
                        System.out.println("进入3");
                        mv = new ModelAndView("student");
                        HttpSession session = request.getSession();
                        session.setAttribute("user",u.getU_name());
                        session.setAttribute("u_id",u.getU_id());
                        mv.addObject("user",u);
                    }else {
                        mv = new ModelAndView("login");
                    }
                }else {
                    mv = new ModelAndView("login");
                }
            }else {
                mv = new ModelAndView("login");
            }
        }catch (Exception e){
            System.out.println("出现错误");
            mv = new ModelAndView("login");
        }


        return mv;
    }
//    @RequestMapping("/test")
//    @ResponseBody
//    public Map<String,Object> test(){
//        Map<String,Object> map=new HashMap<>();
//        map.put("id","1");
//        map.put("username","2");
//        return map;
//    }
}

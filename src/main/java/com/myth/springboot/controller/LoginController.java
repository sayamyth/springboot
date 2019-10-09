package com.myth.springboot.controller;

import com.myth.springboot.entity.User;
import com.myth.springboot.service.LoginService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.ibatis.annotations.Mapper;
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

    @RequestMapping("login")
    public ModelAndView login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv;
        User u = loginService.login(username,password);
        if (u != null){
             mv = new ModelAndView("index");
            HttpSession session = request.getSession();
            session.setAttribute("user",u.getU_name());
            session.setAttribute("u_id",u.getU_id());
            mv.addObject("user",u);
        }else {
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

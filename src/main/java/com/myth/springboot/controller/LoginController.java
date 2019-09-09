package com.myth.springboot.controller;

import com.myth.springboot.entity.User;
import com.myth.springboot.service.LoginService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping("/")
    public String index(){
        return "login";
    }
    @RequestMapping("login")
    public String login(String username, String password, Map<String,Object> map) {

        System.out.println(username + "...." + password);
        try {
            User user = loginService.login(username, password);
            if (user != null) {
                map.put("username",username);
                String type = user.getType();
                System.out.println(type);

                if (type.equals("0")) {
                    return "index";
                }
                else if (type.equals("1")) {
                    return "one";
                } else {
                    return "tow";
                }
            } else {
                return "login";
            }
        } catch (Exception e) {
            System.out.println(666);
            return "login";
        }


    }
}

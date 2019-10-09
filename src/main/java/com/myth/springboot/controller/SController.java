package com.myth.springboot.controller;

import com.myth.springboot.entity.*;
import com.myth.springboot.service.QuestionService;
import com.myth.springboot.service.SService;
import com.myth.springboot.service.TeachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SController {
    @Autowired
    SService sService;
    @Autowired
    QuestionService questionService;
    //查询所有试题
    @Autowired
    TeachingService teachingService;

    @RequestMapping("/getTest")
    @ResponseBody
    public Msg getTest(HttpServletRequest request) {
        //通过session获取user_id
        String id = request.getSession().getAttribute("u_id").toString();
        System.out.println(id);
        //获取评教批次信息
        Result result = sService.selectByUid(id);
        //获取以评教记录
        String user_id = request.getSession().getAttribute("u_id").toString();
        //获取已评教的信息
        List<Mark> marks = sService.selectMark(user_id);

        if (result.getB_type().equals("1")) {
            System.out.println("---进入----");
            List<Teaching> teachings = teachingService.teachingSelect(new Teaching(result.getClass_name()));
            List<Teaching> teachings1 = new ArrayList<>();
            //遍历已评教的信息
//            try {
//
//            }
            for (Mark m:marks){
                for (int i = 0;i<teachings.size();i++){
                    String str1=teachings.get(i).getTe_id().toString();
                    String str2=m.getTe_id();
                    if (str1.equals(str2)){
                        System.out.println(teachings.get(i).getTe_id());
                        System.out.println(m.getTe_id());
                        System.out.println("----1"+i);
                        teachings1.add(teachings.get(i));
                        teachings.remove(i);

                    }else {
                        System.out.println(teachings.get(i).getTe_id());
                        System.out.println(m.getTe_id());
                        System.out.println("----2"+i);
                    }
                }
            }
            return Msg.success().add("data", result).add("t", teachings).add("y",teachings1);
        } else {
            return Msg.success().add("data", result);
        }
    }
    //

    @RequestMapping("/selectMarkByUid")
    @ResponseBody
    public Msg selectMarkByUid(HttpServletRequest request){
        String user_id = request.getSession().getAttribute("u_id").toString();
        List<Mark> marks = sService.selectMark(user_id);
        return Msg.success();
    }

    //添加记录
    @RequestMapping("/addMark")
    @ResponseBody
    public Msg addMark(String te_id,String point,HttpServletRequest request){
        String user_id = request.getSession().getAttribute("u_id").toString();
        System.out.println(user_id+"------------");
        int i = sService.insertMark(te_id,user_id,point);
        if (i>0){
            return Msg.success().add("msg","评教成功");
        }else {
            return Msg.success().add("msg","评教失败");
        }
    }

}

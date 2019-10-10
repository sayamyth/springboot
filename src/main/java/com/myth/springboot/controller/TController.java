package com.myth.springboot.controller;

import com.myth.springboot.entity.*;

import com.myth.springboot.service.TService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class TController {
    @Autowired
    TService tService;
    @Autowired
    QuestionsController questionsController;
    //查询所有试题



    //得到一个部门的老师信息
    @RequestMapping("/getTeacherInfo")
    @ResponseBody
    public Msg getTeacher(HttpServletRequest request){
        String u_name=request.getSession().getAttribute("user").toString();
        ResultTeacher resultTeacher = tService.selectTeacherByUname(u_name);
        String dept_id=resultTeacher.getD_id();
        List<Teacher> teachers = tService.selectTeachersByDeptId(dept_id);
        return Msg.success().add("data",teachers);
    }

    //得到同行评教试题
    @RequestMapping("/getEachTest")
    @ResponseBody
    public ModelAndView getEachTest(String teacher_id){
        ModelAndView mv= new ModelAndView("t/list1");
        List<Questions> questions = tService.selectTest();
        mv.addObject("q",questions);
        mv.addObject("t",teacher_id);
        return mv;
    }

    //插入同行评教信息

    @RequestMapping("/insertTmark")
    @ResponseBody
    public Msg insertTmark(String teacher_id,String point,HttpServletRequest request){
        String role_id=request.getSession().getAttribute("u_id").toString();
        Date date = new Date();
        String time = String.format("%tY", date)+"";

        Tmark tmark=tService.selectMark(teacher_id,role_id,time);

        if (tmark != null){
            return Msg.success().add("msg","今年已对其评教！");
        }else {
            int i = tService.insertMark(teacher_id,role_id,time,point);
            if (i>0){
                return Msg.success().add("msg","同行评教成功！");
            }else {
                return Msg.success().add("msg","同行评教失败！");
            }
        }


    }



}

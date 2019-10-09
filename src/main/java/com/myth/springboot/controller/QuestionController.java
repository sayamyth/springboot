package com.myth.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.springboot.entity.Msg;
import com.myth.springboot.entity.Question;
import com.myth.springboot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QuestionController {
    @Autowired
    QuestionService questionService;
    //查询所有试题

    @RequestMapping("/selectQuestion")
    @ResponseBody
    public Msg selectQuestion(){

        Question question=new Question();
        List<Question> list=questionService.selectQuestion(question);

        return Msg.success().add("data",list);
    }
    @RequestMapping("/selectQuestion1")
    @ResponseBody
    public ModelAndView selectQuestion1(String te_id){
        ModelAndView mv = new ModelAndView("s/list1");
        mv.addObject("te_id",te_id);
        System.out.println(te_id);
        Question question=new Question();
        List<Question> list=questionService.selectQuestion(question);
        mv.addObject("q",list);
        return mv;
    }
    @RequestMapping("/selectQuestionWithPage")
    @ResponseBody
    public Map selectQuestion(String page,String limit){
        PageHelper.startPage(Integer.valueOf(page).intValue(),Integer.valueOf(limit).intValue());
        Question question=new Question();
        List<Question> list=questionService.selectQuestion(question);
        PageInfo pageInfo=new PageInfo(list,5);
        Map<String,Object> map=new HashMap<>();
        map.put("data",pageInfo);
        return map;

    }
    //根据ID查找试题
    @RequestMapping("/selectQuestionById")
    @ResponseBody
    public ModelAndView selectQuestionById(int q_id){
        ModelAndView mv = new ModelAndView("question/question-update");
        Question question=new Question();
        question.setQ_id(q_id);
        Question list=questionService.selectQuestionById(q_id).get(0);
        mv.addObject("question",list);
        return mv;

    }
    //修改试题
    @RequestMapping("/updateQuestion")
    @ResponseBody
    public Msg updateQuestion(int q_id,String question,String answer1,String answer2,String answer3,String answer4,String point){
        Question question1=new Question();
        question1.setQ_id(q_id);
        question1.setQuestion(question);
        question1.setAnswer1(answer1);
        question1.setAnswer2(answer2);
        question1.setAnswer3(answer3);
        question1.setAnswer4(answer4);
        question1.setPoint(point);
        int i=questionService.updateQuestion(question1);
        if(i>0){
            return Msg.success().add("msg","修改试题成功");
        }else {
            return Msg.success().add("msg","修改试题失败");
        }
    }
    //根据题目查找试题
    @RequestMapping("/selectQuestionByName")
    @ResponseBody
    public ModelAndView selectQuestionByName(String question){
        ModelAndView mv = new ModelAndView("question/question-add");
        Question question1=new Question();
        question1.setQuestion(question);
        Question list=questionService.selectQuestionByName(question).get(0);
        mv.addObject("question",list);
        return mv;
    }
    //添加试题
    @RequestMapping("/addQuestion")
    @ResponseBody
    public Msg addQuestion(@PathParam("question") String question, @PathParam("answer1")String answer1,
                           @PathParam("answer2")String answer2, @PathParam("answer3")String answer3,
                           @PathParam("answer4")String answer4, @PathParam("point")String point){
        List<Question> ques=questionService.selectQuestionByName(question);
        if (!ques.isEmpty()){
            return Msg.success().add("msg","已有该试题，不能重复添加");
        }
        //获得所有占比
        float pointo=Float.parseFloat(questionService.selectPoint());
        float sum=Float.parseFloat(point);
        if(pointo+sum>1){
            return Msg.success().add("msg","所有试题占比不能超过1,现有"+pointo);

        }
        Question qs=new Question();
        qs.setQuestion(question);
        qs.setAnswer1(answer1);
        qs.setAnswer2(answer2);
        qs.setAnswer3(answer3);
        qs.setAnswer4(answer4);
        qs.setPoint(point);
        int i=questionService.addQuestion(qs);
        if (i>0){
            return Msg.success().add("msg","添加试题成功");
        }else {
            return Msg.success().add("msg","添加试题失败");
        }
    }
    //删除试题
    @RequestMapping("/deleteQuestion")
    @ResponseBody
    public Msg deleteQuestion(String id){
//        Question question=new Question();
//        question.setQ_id(q_id);
        System.out.println(id);
        int i=questionService.deleteQuestion(Integer.valueOf(id).intValue());
        if(i>0){
            return Msg.success().add("msg","删除成功");
        }else {
            return Msg.success().add("msg","删除试题失败");
        }
    }
    //多条删除
    @RequestMapping("/deleteQuestionMany")
    @ResponseBody
    public Msg deleteQuestionMany(String id){
        String str[] = id.split(",");
        String s = "";
        for (int i = 0; i < str.length; i++) {
            Integer q_id = Integer.valueOf(str[i]).intValue();
            Question question = new Question();
            question.setQ_id(q_id);
            int j = questionService.deleteQuestion(q_id);
            if (j > 0) {
                s += str[i] + "试题删除成功";
            } else {
                s += str[i] + "试题删除失败";
            }
        }
        return Msg.success().add("msg",s);
    }
}

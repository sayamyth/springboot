package com.myth.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myth.springboot.entity.Msg;
import com.myth.springboot.entity.Question;
import com.myth.springboot.entity.Questions;
import com.myth.springboot.service.QuestionService;
import com.myth.springboot.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QuestionsController {
    @Autowired
    QuestionsService questionsService;
    //查询所有试题
    @RequestMapping("/selectQuestions")
    @ResponseBody
    public Map selectQuestions(){
        PageHelper.startPage(1,10);
        Questions questions=new Questions();
        List<Questions> list=questionsService.selectQuestions(questions);
        PageInfo pageInfo=new PageInfo(list,5);
        Map<String,Object> map=new HashMap<>();
        map.put("data",pageInfo);
        return map;

    }
    //根据ID查找试题
    @RequestMapping("/selectQuestionsById")
    @ResponseBody
    public ModelAndView selectQuestionsById(int q_id){
        ModelAndView mv = new ModelAndView("questions/questions-update");
        Questions questions=new Questions();
        questions.setQ_id(q_id);
        Questions list=questionsService.selectQuestionsById(q_id).get(0);
        mv.addObject("questions",list);
        return mv;

    }
    //修改试题
    @RequestMapping("/updateQuestions")
    @ResponseBody
    public Msg updateQuestions(int q_id,String question,String answer1,String answer2,String answer3,String answer4,String point){
        Questions question1=new Questions();
        question1.setQ_id(q_id);
        question1.setQuestion(question);
        question1.setAnswer1(answer1);
        question1.setAnswer2(answer2);
        question1.setAnswer3(answer3);
        question1.setAnswer4(answer4);
        question1.setPoint(point);
        int i=questionsService.updateQuestions(question1);
        if(i>0){
            return Msg.success().add("msg","修改试题成功");
        }else {
            return Msg.success().add("msg","修改试题失败");
        }
    }
    //根据题目查找试题
    @RequestMapping("/selectQuestionsByName")
    @ResponseBody
    public ModelAndView selectQuestionsByName(String question){
        ModelAndView mv = new ModelAndView("questions/questions-add");
        Questions question1=new Questions();
        question1.setQuestion(question);
        Questions list=questionsService.selectQuestionsByName(question).get(0);
        mv.addObject("question",list);
        return mv;
    }
    //添加试题
    @RequestMapping("/addQuestions")
    @ResponseBody
    public Msg addQuestions(@PathParam("question") String question, @PathParam("answer1")String answer1,
                           @PathParam("answer2")String answer2, @PathParam("answer3")String answer3,
                           @PathParam("answer4")String answer4, @PathParam("point")String point){
        List<Questions> ques=questionsService.selectQuestionsByName(question);
        if (!ques.isEmpty()){
            return Msg.success().add("msg","已有该试题，不能重复添加");
        }
        //获得所有占比
        float pointo;
        if (questionsService.selectPoint()==null){
           pointo=0;
        }else {
            pointo= Float.parseFloat(questionsService.selectPoint());
        }

        float sum=Float.parseFloat(point);
        if(pointo+sum>1){
            return Msg.success().add("msg","所有试题占比不能超过1,现有"+pointo);

        }
        Questions qs=new Questions();
        qs.setQuestion(question);
        qs.setAnswer1(answer1);
        qs.setAnswer2(answer2);
        qs.setAnswer3(answer3);
        qs.setAnswer4(answer4);
        qs.setPoint(point);
        int i=questionsService.addQuestions(qs);
        if (i>0){
            return Msg.success().add("msg","添加试题成功");
        }else {
            return Msg.success().add("msg","添加试题失败");
        }
    }
    //删除试题
    @RequestMapping("/deleteQuestions")
    @ResponseBody
    public Msg deleteQuestions(String id){
//        Question question=new Question();
//        question.setQ_id(q_id);
        System.out.println(id);
        int i=questionsService.deleteQuestions(Integer.valueOf(id).intValue());
        if(i>0){
            return Msg.success().add("msg","删除成功");
        }else {
            return Msg.success().add("msg","删除试题失败");
        }
    }
    //多条删除
    @RequestMapping("/deleteQuestionsMany")
    @ResponseBody
    public Msg deleteQuestionsMany(String id){
        String str[] = id.split(",");
        String s = "";
        for (int i = 0; i < str.length; i++) {
            Integer q_id = Integer.valueOf(str[i]).intValue();
            Questions question = new Questions();
            question.setQ_id(q_id);
            int j = questionsService.deleteQuestions(q_id);
            if (j > 0) {
                s += str[i] + "试题删除成功";
            } else {
                s += str[i] + "试题删除失败";
            }
        }
        return Msg.success().add("msg",s);
    }
}

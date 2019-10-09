package com.myth.springboot.service;

import com.myth.springboot.dao.QuestionMapper;
import com.myth.springboot.dao.QuestionsMapper;
import com.myth.springboot.entity.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {
    @Autowired
    QuestionsMapper mapper;
    //查询所有试题
    public List<Questions> selectQuestions(Questions questions){
        return mapper.selectQuestions(questions);
    }
    //修改试题
    public int updateQuestions(Questions questions){
        return mapper.updateQuestions(questions);
    }
    //根据ID查找试题
    public List<Questions> selectQuestionsById(int q_id){
        return mapper.selectQuestionsById(q_id);
    }
    //添加试题
    public int addQuestions(Questions questions){
        return mapper.addQuestions(questions);
    }
    //根据题目查找试题
    public List<Questions> selectQuestionsByName(String question){
        return mapper.selectQuestionsByName(question);
    }
    //删除试题
    public int deleteQuestions(int q_id){
        return mapper.deleteQuestions(q_id);
    }
    //查询所有占比
    public String selectPoint(){
        return mapper.selectPoint();
    }
}

package com.myth.springboot.service;

import com.myth.springboot.dao.QuestionMapper;
import com.myth.springboot.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionService {
    @Autowired
    QuestionMapper mapper;
    //查询所有试题
    public List<Question> selectQuestion(Question question){
        return mapper.selectQuestion(question);
    }
    //修改试题
    public int updateQuestion(Question question){
        return mapper.updateQuestion(question);
    }
    //根据ID查找试题
    public List<Question> selectQuestionById(int q_id){
        return mapper.selectQuestionById(q_id);
    }
    //添加试题
    public int addQuestion(Question question){
        return mapper.addQuestion(question);
    }
    //根据题目查找试题
    public List<Question> selectQuestionByName(String question){
        return mapper.selectQuestionByName(question);
    }
    //删除试题
    public int deleteQuestion(int q_id){
        return mapper.deleteQuestion(q_id);
    }
    //查询所有占比
    public String selectPoint(){
        return mapper.selectPoint();
    }
}

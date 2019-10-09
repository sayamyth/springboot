package com.myth.springboot.dao;

import com.myth.springboot.entity.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface QuestionMapper {
    //查询所有试题
    List<Question> selectQuestion(Question question);
    //修改试题
    int updateQuestion(Question question);
    //根据ID查找试题
    List<Question> selectQuestionById(int q_id);
    //添加试题
    int addQuestion(Question question);
    //根据题目查找试题
    List<Question> selectQuestionByName(String question);
    //删除试题
    int deleteQuestion(int q_id);
    //查询所有占比
    String selectPoint();
}


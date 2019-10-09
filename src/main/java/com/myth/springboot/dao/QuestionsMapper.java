package com.myth.springboot.dao;

import com.myth.springboot.entity.Questions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionsMapper {
    //查询所有试题
    List<Questions> selectQuestions(Questions questions);
    //修改试题
    int updateQuestions(Questions questions);
    //根据ID查找试题
    List<Questions> selectQuestionsById(int q_id);
    //添加试题
    int addQuestions(Questions questions);
    //根据题目查找试题
    List<Questions> selectQuestionsByName(String question);
    //删除试题
    int deleteQuestions(int q_id);
    //查询所有占比
    String selectPoint();
}


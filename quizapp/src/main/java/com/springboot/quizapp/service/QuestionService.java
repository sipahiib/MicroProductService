package com.springboot.quizapp.service;

import com.springboot.quizapp.Question;
import com.springboot.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions()
    {
        return questionDao.findAll();
    }
}

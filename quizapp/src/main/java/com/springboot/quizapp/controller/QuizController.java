package com.springboot.quizapp.controller;


import com.springboot.quizapp.model.QuestionWrapper;
import com.springboot.quizapp.model.Response;
import com.springboot.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int num, @RequestParam String title)
    {
        return  quizService.createQuiz(category,num,title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id)
    {
        return quizService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> response)
    {
    return quizService.calculateResult(id, response);
    }
}

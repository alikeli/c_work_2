package com.example.c_work_2.controllers;

import com.example.c_work_2.services.Question;
import com.example.c_work_2.services.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam(name = "question") String question, @RequestParam(name = "answer") String answer) {
        return questionService.addQuestion(question, answer);
    }


    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam(name = "question") String question, @RequestParam(name = "answer") String answer) {
        return questionService.removeQuestion(question, answer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

}

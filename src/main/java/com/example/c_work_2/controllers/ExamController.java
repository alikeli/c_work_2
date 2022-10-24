package com.example.c_work_2.controllers;

import com.example.c_work_2.services.ExaminerService;
import com.example.c_work_2.services.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/get/")
    public  Collection<Question>getQuestion(@RequestParam(name = "amount")int amount) {
        return examinerService.getQuestion(amount);
    }


}

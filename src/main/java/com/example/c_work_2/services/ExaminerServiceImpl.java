package com.example.c_work_2.services;

import com.example.c_work_2.exceptions.LimitQuestionsException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new LimitQuestionsException();
        }
        Set<Question> examQuestions = new HashSet<>(amount);
        while (examQuestions.size() < amount) {
            examQuestions.add(questionService.getRandomQuestion());
        }

        return examQuestions;

    }
}

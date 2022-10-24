package com.example.c_work_2.services;

import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface QuestionService {
    Question addQuestion(String question, String answer);
    Question addQuestion(Question question);

    Question removeQuestion(String question, String answer);

    Collection<Question> getAll();

    String getRandomQuestion();
}

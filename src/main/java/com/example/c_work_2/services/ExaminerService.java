package com.example.c_work_2.services;

import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface ExaminerService {
    Collection<Question>getQuestion(int amount);
}

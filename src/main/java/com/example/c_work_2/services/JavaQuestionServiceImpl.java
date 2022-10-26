package com.example.c_work_2.services;

import com.example.c_work_2.exceptions.QuestionAlreadyAddedException;

import com.example.c_work_2.exceptions.QuestionNotFoundException;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {
    private final Set<Question> questions;

    public JavaQuestionServiceImpl() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question addQuestion(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (questions.contains(question1)) {
            throw new QuestionAlreadyAddedException("Вопрос уже существует");
        }

        questions.add(question1);

        return question1;

    }

    @Override
    public Question addQuestion(Question question) {

        if (questions.contains(question)) {
            throw new QuestionAlreadyAddedException("Вопрос уже существует");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question removeQuestion(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (questions.contains(question1)) {
            questions.remove(question1);
            return question1;
        }
        throw new QuestionNotFoundException();

    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();

        return questions.stream().skip(random.nextInt(questions.size())).findFirst().get();
    }

}

package com.example.c_work_2.services;

import java.util.Objects;

public class Question {
    private String question;
    private String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }


    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Question{" + "question='" + question + '\'' + ", answer='" + answer + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return getQuestion().equals(question1.getQuestion()) && getAnswer().equals(question1.getAnswer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestion(), getAnswer());
    }
}

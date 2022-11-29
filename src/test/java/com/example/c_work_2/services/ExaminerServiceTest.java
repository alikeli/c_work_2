package com.example.c_work_2.services;

import com.example.c_work_2.exceptions.LimitQuestionsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceTest {
    @Mock
    private JavaQuestionServiceImpl questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void beforeEach() {
        when(questionService.getAll()).thenReturn(List.of(
                new Question("QuestionText", "QuestionAnswer"),
                new Question("QuestionText1", "QuestionAnswer1"),
                new Question("QuestionText2", "QuestionAnswer2"),
                new Question("QuestionText3", "QuestionAnswer3")));

    }

    @Test
    public void shouldThrowLimitQuestionsExceptionTest() {

        assertThatExceptionOfType(LimitQuestionsException.class).isThrownBy(() -> examinerService.getQuestion(5));
        assertThatExceptionOfType(LimitQuestionsException.class).isThrownBy(() -> examinerService.getQuestion(0));
    }

    @Test
    public void shouldReturnCollectionOfQuestions() {
        Set<Question> questionSet = new HashSet<Question>(Set.of(
                new Question("QuestionText", "QuestionAnswer"),
                new Question("QuestionText1", "QuestionAnswer1")));
        when(questionService.getAll()).thenReturn(questionSet);
        when(questionService.getRandomQuestion()).thenReturn(
                new Question("QuestionText", "QuestionAnswer"),
                new Question("QuestionText1", "QuestionAnswer1"));
        assertEquals(questionSet, examinerService.getQuestion(2));
    }


    public static Stream<Arguments> provideParamsForGetQuestion() {
        return Stream.of(
                Arguments.of(1, new Question("QuestionText", "QuestionAnswer")),
                Arguments.of(2, new Question("QuestionText1", "QuestionAnswer1")),
                Arguments.of(3, new Question("QuestionText2", "QuestionAnswer2")),
                Arguments.of(4, new Question("QuestionText3", "QuestionAnswer3")));
    }
}
package com.example.c_work_2.services;
import com.example.c_work_2.exceptions.QuestionAlreadyAddedException;
import com.example.c_work_2.exceptions.QuestionNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Set;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class QuestionServiceTest {
    private final JavaQuestionServiceImpl questionService = new JavaQuestionServiceImpl() {
    };

    @Test
    public void shouldAddQuestionTest() {
        Question question = new Question("QuestionText", "QuestionAnswer");
        Question question1 = new Question("QuestionText1", "QuestionAnswer1");
        assertThat(questionService.getAll()).isEmpty();
        questionService.addQuestion("QuestionText", "QuestionAnswer");
        questionService.addQuestion("QuestionText1", "QuestionAnswer1");
        assertThat(questionService.getAll())
                .isNotEmpty()
                .hasSize(2)
                .contains(question)
                .contains(question1);

    }

    public Question addQuestionForTest() {
        Question question = new Question("QuestionText", "QuestionAnswer");

        assertThat(questionService.getAll()).isEmpty();
        questionService.addQuestion("QuestionText", "QuestionAnswer");

        assertThat(questionService.getAll())
                .isNotEmpty()
                .hasSize(1)
                .contains(question);

        return question;

    }

    @Test
    public void shouldThrowQuestionAlreadyAddedExceptionTest() {
        Question question = addQuestionForTest();
        assertThatExceptionOfType(QuestionAlreadyAddedException.class)
                .isThrownBy(() -> questionService.addQuestion(question));

    }


    @Test
   public void shouldRemoveQuestionTest() {
        Question question = addQuestionForTest();
        questionService.removeQuestion(question.getQuestion(), question.getAnswer());
        assertThat(questionService.getAll()).isEmpty();
    }
    @Test
    public void shouldThrowQuestionNotFoundExceptionTest() {
        Question question = addQuestionForTest();
        questionService.removeQuestion(question.getQuestion(),question.getAnswer());
        assertThat(questionService.getAll()).isEmpty();
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> questionService.removeQuestion(question.getQuestion(),question.getAnswer()));


    }

    @Test
    public void shouldGetAll() {
        Question question = addQuestionForTest();


        assertThat(questionService.getAll())
                .isNotEmpty()
                .hasSize(1)
                .contains(question);

    }

    @ParameterizedTest
    @MethodSource("provideParamsForQuestions")
    public void shouldGetRandomTest(Set<Question> questions) {
        questions.forEach(x -> questionService.addQuestion(x.getQuestion(),x.getAnswer()));
        assertThat(questionService.getAll()).hasSize(questions.size());
        assertThat(questionService.getRandomQuestion()).isIn(questionService.getAll());
    }

    public static Stream<Arguments> provideParamsForQuestions() {
        return Stream.of(Arguments.of(Set.of(
                new Question("QuestionText", "QuestionAnswer"),
                new Question("QuestionText1", "QuestionAnswer1"),
                new Question("QuestionText2", "QuestionAnswer2"))));
    }


}
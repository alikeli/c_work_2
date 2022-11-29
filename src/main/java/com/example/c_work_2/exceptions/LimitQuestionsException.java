package com.example.c_work_2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class LimitQuestionsException extends RuntimeException {
    public LimitQuestionsException() {
    }

    public LimitQuestionsException(String message) {
        super(message);
    }

    public LimitQuestionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public LimitQuestionsException(Throwable cause) {
        super(cause);
    }

    public LimitQuestionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

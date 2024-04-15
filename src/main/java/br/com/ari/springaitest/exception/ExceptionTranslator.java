package br.com.ari.springaitest.exception;

import org.springframework.ai.openai.api.common.OpenAiApiClientErrorException;
import org.springframework.ai.openai.api.common.OpenAiApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionTranslator extends ResponseEntityExceptionHandler {

    public static final String OPEN_AI_CLIENT_RAISED_EXCEPTION = "Open AI client raised exception";

    @ExceptionHandler(OpenAiApiClientErrorException.class)
    ProblemDetail handleOpenAiApiClientErrorException(OpenAiApiClientErrorException exc) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exc.getMessage());
        problemDetail.setTitle(OPEN_AI_CLIENT_RAISED_EXCEPTION);
        return problemDetail;
    }

    @ExceptionHandler(OpenAiApiException.class)
    ProblemDetail handleOpenAiApiException(OpenAiApiException exc) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, exc.getMessage());
        problemDetail.setTitle(OPEN_AI_CLIENT_RAISED_EXCEPTION);
        return problemDetail;
    }

}

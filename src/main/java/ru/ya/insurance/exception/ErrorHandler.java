package ru.ya.insurance.exception;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.InvalidParameterException;

@RestControllerAdvice
public class ErrorHandler {

    @SuppressWarnings("S1068")
    private ErrorResponse errorResponse;
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler({
            NotFoundException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(final Exception e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            InvalidParameterException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException(final Exception e) {
        logger.error("Server error: {}", e.getMessage());
        return new ErrorResponse("See logs for more information.");
    }

    @ExceptionHandler({
            Exception.class
    })
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse globalExceptionHandler(final Exception e) {
        logger.error("Server error: {}", e.getMessage());
        return new ErrorResponse("See logs for more information.");
    }

    @Getter
    private static class ErrorResponse {
        private final String error;

        public ErrorResponse(String error) {
            this.error = error;
        }
    }

}
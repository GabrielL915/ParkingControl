package com.gabrielgomes.parking_control.api.exception;

import com.gabrielgomes.parking_control.util.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Order(Ordered.HIGHEST_PRECEDENCE + 1)
@ControllerAdvice
public class GlobalAPIExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    private ErrorResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return getErrorResponse(exception, HttpStatus.BAD_REQUEST);
    }

    private ErrorResponse getErrorResponse(Exception exception, HttpStatus status) {
        return ErrorResponse.builder()
                .title(exception.getClass().getSimpleName())
                .code(status.toString())
                .details(exception.getMessage())
                .build();
    }
}

package com.gabrielgomes.parking_control.api.exception;

import com.gabrielgomes.parking_control.util.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class BeanValidationAPIExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException methodArgumentNotValidException,
            HttpHeaders headers,
            HttpStatusCode status, WebRequest webRequest
    ) {
        List<ErrorResponse.Field> fields = new ArrayList<>();

        for (ObjectError error : methodArgumentNotValidException.getBindingResult().getAllErrors()) {
            fields.add(buildErrorResponseField((FieldError) error));
        }

        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(status.toString())
                .message("One or more fields are invalid. Please fill in correctly and try again.")
                .fields(fields)
                .build();

        return handleExceptionInternal(methodArgumentNotValidException, errorResponse, headers, status, webRequest);
    }

    private ErrorResponse.Field buildErrorResponseField(FieldError error) {
        String name = error.getField();
        String message = error.getDefaultMessage();
        return new ErrorResponse.Field(name, message);
    }
}

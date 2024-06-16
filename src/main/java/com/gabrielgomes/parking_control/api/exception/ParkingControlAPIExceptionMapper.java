package com.gabrielgomes.parking_control.api.exception;

import com.gabrielgomes.parking_control.service.exception.EntityAlreadyExistsException;
import com.gabrielgomes.parking_control.service.exception.EntityNotFoundException;
import com.gabrielgomes.parking_control.service.exception.ParkingControlStandardException;
import com.gabrielgomes.parking_control.util.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ParkingControlAPIExceptionMapper {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse mapParkingControlStandardExceptionWithNotFound(ParkingControlStandardException exception) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse mapParkingControlStandardExceptionWithConflict(ParkingControlStandardException exception) {
        return buildErrorResponse(HttpStatus.CONFLICT, exception);
    }

    private ErrorResponse buildErrorResponse(HttpStatus httpStatus, ParkingControlStandardException exception) {
        return ErrorResponse.builder()
                .code(httpStatus.toString())
                .message(exception.getDefaultMessage())
                .details(exception.getMessage())
                .messageCode(exception.getDefaultMessageKey())
                .build();
    }
}

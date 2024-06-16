package com.gabrielgomes.parking_control.api.exception;

import com.gabrielgomes.parking_control.service.exception.EntityAlreadyExistsException;
import com.gabrielgomes.parking_control.service.exception.EntityNotFoundException;
import com.gabrielgomes.parking_control.service.exception.ParkingControlStandardException;
import com.gabrielgomes.parking_control.util.ErrorResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParkingControlAPIExceptionMapperTest {

    private static final String NOT_FOUND_STATUS_CODE = "404 NOT_FOUND";
    private static final String CONFLICT_STATUS_CODE = "409 CONFLICT";

    private static final String ERROR_MESSAGE = "Error";
    private static final String PARKING_CONTROL_EXCEPTION_DEFAULT_MESSAGE = "Default error message";
    private static final String PARKING_CONTROL_EXCEPTION_DEFAULT_MESSAGE_KEY = "parking-control.key";

    @InjectMocks
    private ParkingControlAPIExceptionMapper parkingControlAPIExceptionMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void should_map_parking_control_standard_exception_with_not_found() {
        EntityNotFoundException exception = mockParkingControlStandardException(EntityNotFoundException.class);

        ErrorResponse errorResponse = parkingControlAPIExceptionMapper.mapParkingControlStandardExceptionWithNotFound(exception);

        assertErrorResponse(errorResponse, NOT_FOUND_STATUS_CODE);
    }

    @Test
    void should_map_parking_control_standard_exception_with_conflict() {
        EntityAlreadyExistsException exception = mockParkingControlStandardException(EntityAlreadyExistsException.class);

        ErrorResponse errorResponse = parkingControlAPIExceptionMapper.mapParkingControlStandardExceptionWithConflict(exception);

        assertErrorResponse(errorResponse, CONFLICT_STATUS_CODE);
    }

    private <T extends ParkingControlStandardException> T mockParkingControlStandardException(Class<? extends ParkingControlStandardException> parkingControlStandardExceptionClass) {
        T exception = (T) mock(parkingControlStandardExceptionClass);

        when(exception.getDefaultMessage()).thenReturn(PARKING_CONTROL_EXCEPTION_DEFAULT_MESSAGE);
        when(exception.getMessage()).thenReturn(ERROR_MESSAGE);
        when(exception.getDefaultMessageKey()).thenReturn(PARKING_CONTROL_EXCEPTION_DEFAULT_MESSAGE_KEY);

        return exception;
    }

    private void assertErrorResponse(ErrorResponse errorResponse, String expectedCode) {
        assertEquals(expectedCode, errorResponse.getCode());
        assertEquals(PARKING_CONTROL_EXCEPTION_DEFAULT_MESSAGE, errorResponse.getMessage());
        assertEquals(ERROR_MESSAGE, errorResponse.getDetails());
        assertEquals(PARKING_CONTROL_EXCEPTION_DEFAULT_MESSAGE_KEY, errorResponse.getMessageCode());
    }
}
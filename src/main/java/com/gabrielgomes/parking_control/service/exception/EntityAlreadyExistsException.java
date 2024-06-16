package com.gabrielgomes.parking_control.service.exception;

public class EntityAlreadyExistsException extends ParkingControlStandardException {

    private static final String DEFAULT_MESSAGE = "An entity with this identifier or key already exists.";

    private static final String DEFAULT_MESSAGE_KEY = "parking-control.entity-already-exists.error";

    public EntityAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    public String getDefaultMessage() {
        return DEFAULT_MESSAGE;
    }

    @Override
    public String getDefaultMessageKey() {
        return DEFAULT_MESSAGE_KEY;
    }
}

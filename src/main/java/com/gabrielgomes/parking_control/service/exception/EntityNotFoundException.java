package com.gabrielgomes.parking_control.service.exception;

import java.util.function.Supplier;

public class EntityNotFoundException extends ParkingControlStandardException {

    private static final String DEFAULT_MESSAGE = "Unable to find entity.";

    private static final String DEFAULT_MESSAGE_KEY = "parking-control.entity-not-found.error";

    public EntityNotFoundException(Object id) {
        super(String.format("Entity with id %s not found.", id));
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

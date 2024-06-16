package com.gabrielgomes.parking_control.service.exception;

import org.apache.commons.lang3.StringUtils;

public abstract class ParkingControlStandardException extends RuntimeException {

    protected ParkingControlStandardException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        return StringUtils.isNotBlank(message) ? message : this.getDefaultMessage();
    }

    public abstract String getDefaultMessage();

    public abstract String getDefaultMessageKey();
}

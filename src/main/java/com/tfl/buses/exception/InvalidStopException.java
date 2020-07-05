package com.tfl.buses.exception;

public class InvalidStopException extends RuntimeException {

    public InvalidStopException(String msg) {
        super(msg);
    }
}

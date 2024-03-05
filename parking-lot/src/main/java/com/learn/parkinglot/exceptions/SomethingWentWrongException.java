package com.learn.parkinglot.exceptions;

public class SomethingWentWrongException extends RuntimeException {
    public SomethingWentWrongException(String s) {
        super(s);
    }
}

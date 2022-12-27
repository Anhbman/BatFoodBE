package com.hust.doan.exception;

public class InputException extends RuntimeException {
    public InputException(String mess) {
        super(String.format(mess + " Input error"));
    }
}

package com.hust.doan.exception;

public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException(String mess) {
        super(String.format(mess + " not found"));
    }
}

package com.hust.doan.exception;


public class UserExitsException extends RuntimeException{

    public UserExitsException(String mess) {
        super(String.format(mess + " exits"));
    }
}

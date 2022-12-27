package com.hust.doan.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String staffId) {
        super(String.format(staffId + " user not found"));
    }
}

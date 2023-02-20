package com.hust.doan.exception;

public class WebServiceException extends RuntimeException {
    public WebServiceException(String mess) {
        super(String.format(mess));
    }
}

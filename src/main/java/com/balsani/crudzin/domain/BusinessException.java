package com.balsani.crudzin.domain;

public class BusinessException extends RuntimeException{

    public BusinessException(String message) {
        super(message);
    }
}

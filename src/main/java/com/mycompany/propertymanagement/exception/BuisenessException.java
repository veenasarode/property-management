package com.mycompany.propertymanagement.exception;

public class BuisenessException extends RuntimeException{

    private String message;

    public BuisenessException(){}

    public BuisenessException(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

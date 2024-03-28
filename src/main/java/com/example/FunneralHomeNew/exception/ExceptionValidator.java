package com.example.FunneralHomeNew.exception;

public class ExceptionValidator extends Exception{
    private String errorMessage;

    public ExceptionValidator(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
}

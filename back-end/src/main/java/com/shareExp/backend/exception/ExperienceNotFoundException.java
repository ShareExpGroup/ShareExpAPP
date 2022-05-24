package com.shareExp.backend.exception;

public class ExperienceNotFoundException extends GeneralException{
    public ExperienceNotFoundException(String code, String message) {
        super(code, message);
    }

    public ExperienceNotFoundException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public ExperienceNotFoundException(String code, Exception exception) {
        super(code, exception);
    }

    public ExperienceNotFoundException(Exception exception) {
        super(exception);
    }

    public ExperienceNotFoundException(long id) {
        super(ExperienceNotFoundException.class.getSimpleName(),"the offer : "+id+" does not exist");
    }
}

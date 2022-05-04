package com.shareExp.backend.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(long id) {
        super("User not found with id : " + id);
    }

    public UserNotFoundException(String email) {
        super("User not found with email : " + email);
    }
}

package com.shareExp.backend.exception;

public class UserIncompleteDataException extends UserException{

    public UserIncompleteDataException() {
        super(UserIncompleteDataException.class.getSimpleName(),"the user data is incomplete");
    }
    public UserIncompleteDataException(String missingData) {
        super(UserIncompleteDataException.class.getSimpleName(),"the user data is incomplete : missing "+missingData);
    }
}

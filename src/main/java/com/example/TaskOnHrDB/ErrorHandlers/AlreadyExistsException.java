package com.example.TaskOnHrDB.ErrorHandlers;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(String message) {
        super(message);
    }
}

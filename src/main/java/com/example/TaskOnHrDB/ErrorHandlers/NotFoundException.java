package com.example.TaskOnHrDB.ErrorHandlers;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}

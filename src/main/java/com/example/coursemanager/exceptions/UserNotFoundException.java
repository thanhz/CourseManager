package com.example.coursemanager.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(long id) {
        super("Could not find employee" + id);
    }
}

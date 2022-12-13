package com.tutorial.rest.webservices.restfulwebservices.exception;

public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 724271711761017129L;

    public UserNotFoundException(String message) {
        super(message);
    }
}


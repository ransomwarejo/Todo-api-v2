package com.sogel.todo_api_v2.todo_api.exception;



public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

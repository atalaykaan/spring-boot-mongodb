package com.atalaykaan.spring_boot_mongodb.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {

        super(message);
    }
}

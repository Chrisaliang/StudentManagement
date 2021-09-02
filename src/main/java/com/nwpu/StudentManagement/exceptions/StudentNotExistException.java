package com.nwpu.StudentManagement.exceptions;

public class StudentNotExistException extends RuntimeException {
    public StudentNotExistException(String s) {
        super(s);
    }
}

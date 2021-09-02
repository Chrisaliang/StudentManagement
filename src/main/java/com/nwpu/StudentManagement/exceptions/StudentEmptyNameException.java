package com.nwpu.StudentManagement.exceptions;

public class StudentEmptyNameException extends RuntimeException {
    public StudentEmptyNameException(String s) {
        super(s);
    }
}

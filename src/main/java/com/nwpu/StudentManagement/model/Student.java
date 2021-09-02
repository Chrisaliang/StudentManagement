package com.nwpu.StudentManagement.model;

import java.util.UUID;

public class Student {

    private final UUID id;

    private final String name;

    public Student(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //    @JsonIgnore
    public UUID getId() {
        return id;
    }
}

package com.nwpu.StudentManagement.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "university_class_id")
    private UniversityClass universityClass;

    public UniversityClass getUniversityClass() {
        return universityClass;
    }

    public void setUniversityClass(UniversityClass universityClass) {
        this.universityClass = universityClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", universityClass=" + universityClass +
                '}';
    }
}

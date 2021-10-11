package com.nwpu.StudentManagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "university_class")
public class UniversityClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "year")
    private int year;

    @Column(nullable = false, name = "number")
    private int number;

    @OneToMany(mappedBy = "universityClass")
    private List<Student> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "UniversityClass{" +
                "id=" + id +
                ", year=" + year +
                ", number=" + number +
                '}';
    }
}

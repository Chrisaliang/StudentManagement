package com.nwpu.StudentManagement.dao;

import com.nwpu.StudentManagement.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentDao {

    List<Student> selectAllStudent();

    Optional<Student> selectStudentById(UUID id);

    int insertStudent(Student student);

    int updateStudent(Student student);

    int deleteStudentById(UUID id);
}

package com.nwpu.StudentManagement.dao;

import com.nwpu.StudentManagement.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student, Long> {

//    List<Student> selectAllStudent();
//
//    Optional<Student> selectStudentById(UUID id);
//
//    int insertStudent(Student student);
//
//    int updateStudent(Student student);
//
//    int deleteStudentById(UUID id);
}

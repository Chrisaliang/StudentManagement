package com.nwpu.StudentManagement.service;

import com.nwpu.StudentManagement.dao.StudentDao;
import com.nwpu.StudentManagement.exceptions.StudentEmptyNameException;
import com.nwpu.StudentManagement.exceptions.StudentNotExistException;
import com.nwpu.StudentManagement.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Optional<Student> getStudentById(long id) {
        return studentDao.findById(id);
    }

    public List<Student> getAllStudents() {
        return (List<Student>) studentDao.findAll();
    }

    public Student addStudent(Student student) {
        if (student.getName().isEmpty())
            throw new StudentEmptyNameException("Student name can not be empty!");
        return studentDao.save(student);
    }

    public Student updateStudent(Student student) {
        if (student.getId() == null || !studentDao.existsById(student.getId()))
            throw new StudentNotExistException("can not find student id");
        return studentDao.save(student);
    }
}

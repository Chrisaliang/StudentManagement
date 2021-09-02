package com.nwpu.StudentManagement.service;

import com.nwpu.StudentManagement.dao.StudentDao;
import com.nwpu.StudentManagement.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudent();
    }

    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    public int deleteStudentById(UUID id) {
        return studentDao.deleteStudentById(id);
    }
}

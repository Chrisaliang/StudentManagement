package com.nwpu.StudentManagement.service;

import com.nwpu.StudentManagement.dao.StudentDao;
import com.nwpu.StudentManagement.dao.UniversityClassDao;
import com.nwpu.StudentManagement.exceptions.StudentEmptyNameException;
import com.nwpu.StudentManagement.exceptions.StudentNotExistException;
import com.nwpu.StudentManagement.exceptions.UniversityClassException;
import com.nwpu.StudentManagement.model.Student;
import com.nwpu.StudentManagement.model.UniversityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentDao studentDao;
    private final UniversityClassDao universityClassDao;

    @Autowired
    public StudentService(StudentDao studentDao, UniversityClassDao universityClassDao) {
        this.studentDao = studentDao;
        this.universityClassDao = universityClassDao;
    }

    public Optional<Student> getStudentById(long id) {
        return studentDao.findById(id);
    }

    public List<Student> getAllStudents() {
        return (List<Student>) studentDao.findAll();
    }

    public Student assignClass(Long studentId, Long classId) {
        if (!studentDao.existsById(studentId)) {
            throw new StudentNotExistException("can not find student id " + studentId);
        }
        if (!universityClassDao.existsById(classId)) {
            throw new UniversityClassException("can not find class id " + classId);
        }
        Student student = getStudentById(studentId).get();
        UniversityClass universityClass = universityClassDao.findById(classId).get();
        student.setUniversityClass(universityClass);
        return studentDao.save(student);
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

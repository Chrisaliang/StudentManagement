package com.nwpu.StudentManagement.controller;

import com.nwpu.StudentManagement.model.Student;
import com.nwpu.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public String addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "Student added";
    }

    @PutMapping
    public String updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return "Student updated";
    }

    @DeleteMapping(path = "{id}")
    public String deleteStudent(@PathVariable("id") UUID id) {
        studentService.deleteStudentById(id);
        return "Student deleted";
    }
}

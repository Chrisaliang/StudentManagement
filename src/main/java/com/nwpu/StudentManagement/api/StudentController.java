package com.nwpu.StudentManagement.api;

import com.nwpu.StudentManagement.exceptions.StudentEmptyNameException;
import com.nwpu.StudentManagement.exceptions.StudentNotExistException;
import com.nwpu.StudentManagement.exceptions.UniversityClassException;
import com.nwpu.StudentManagement.model.Student;
import com.nwpu.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody Student student) {
        try {
            Student s = studentService.addStudent(student);
            return ResponseEntity.ok("Registered student: " + s);
        } catch (StudentEmptyNameException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PostMapping(path = "assign/{sid}/{cid}")
    public ResponseEntity<String> assignClass(@PathVariable("sid") Long studentId,
                                              @PathVariable("cid") Long classId) {
        try {
            Student student = studentService.assignClass(studentId, classId);
            return ResponseEntity.ok("assigned class " + student.toString());
        } catch (StudentNotExistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (UniversityClassException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping
    public String updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return "Student updated";
    }

//    @DeleteMapping(path = "{id}")
//    public String deleteStudent(@PathVariable("id") UUID id) {
//        studentService.deleteStudentById(id);
//        return "Student deleted";
//    }
}

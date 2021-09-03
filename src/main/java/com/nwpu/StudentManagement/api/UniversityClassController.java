package com.nwpu.StudentManagement.api;

import com.nwpu.StudentManagement.model.UniversityClass;
import com.nwpu.StudentManagement.service.UniversityClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/class")
public class UniversityClassController {

    private final UniversityClassService classService;

    @Autowired
    public UniversityClassController(UniversityClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    public List<UniversityClass> getAllClass() {
        return classService.getAllClass();
    }

    @PostMapping
    public UniversityClass addClass(@RequestBody UniversityClass universityClass) {
        return classService.addClass(universityClass);
    }
}

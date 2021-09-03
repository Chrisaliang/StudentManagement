package com.nwpu.StudentManagement.dao;

import com.nwpu.StudentManagement.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student, Long> {
}

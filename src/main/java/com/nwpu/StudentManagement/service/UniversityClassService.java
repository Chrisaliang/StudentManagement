package com.nwpu.StudentManagement.service;

import com.nwpu.StudentManagement.dao.UniversityClassDao;
import com.nwpu.StudentManagement.exceptions.UniversityClassException;
import com.nwpu.StudentManagement.model.UniversityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class UniversityClassService {

    private final UniversityClassDao classDao;

    @Autowired
    public UniversityClassService(UniversityClassDao classDao) {
        this.classDao = classDao;
    }

    public Optional<UniversityClass> getClassById(Long id) {
        return classDao.findById(id);
    }

    public List<UniversityClass> getAllClass() {
        return (List<UniversityClass>) classDao.findAll();
    }

    public UniversityClass addClass(UniversityClass universityClass) {
        if (universityClass.getYear() < (Calendar.getInstance().get(Calendar.YEAR)) - 10)
            throw new UniversityClassException("can not add a past class");
        if (universityClass.getYear() > Calendar.getInstance().get(Calendar.YEAR) + 10)
            throw new UniversityClassException("can not add a far future class");
        return classDao.save(universityClass);
    }

    public UniversityClass updateUniversityClass(UniversityClass universityClass) {
        if (universityClass.getId() == null || !classDao.existsById(universityClass.getId()))
            throw new UniversityClassException("can not find class id");
        return classDao.save(universityClass);
    }
}

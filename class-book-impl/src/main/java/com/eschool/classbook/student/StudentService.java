package com.eschool.classbook.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<StudentEntity> findAll(Pageable pageable);
    StudentEntity findById(Long id);
    void deleteById(Long id);
    StudentEntity save(StudentEntity studentEntity);
    StudentEntity update(Long id, StudentEntity studentEntity);
}

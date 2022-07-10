package com.eschool.classbook.teacher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {
    Page<TeacherEntity> findAll(Pageable pageable);
    TeacherEntity findById(Long id);
    void deleteById(Long id);
    TeacherEntity save(TeacherEntity teacherEntity);
    TeacherEntity update(Long id, TeacherEntity teacherEntity);
}

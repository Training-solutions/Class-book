package com.eschool.classbook.subject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubjectService {
    Page<SubjectEntity> findAll(Pageable pageable);
    SubjectEntity findById(Long id);
    void deleteById(Long id);
    SubjectEntity save(SubjectEntity subjectEntity);
    SubjectEntity update(Long id, SubjectEntity subjectEntity);
}

package com.eschool.classbook.subject;

import com.eschool.classbook.exception.ClassBookException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService{
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Page<SubjectEntity> findAll(Pageable pageable) {
        return subjectRepository.findAll(pageable);
    }

    @Override
    public SubjectEntity findById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Subject with id %d was not found", id)));
    }

    @Override
    public void deleteById(Long id) {
        SubjectEntity subject = subjectRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Subject with id %d wasn't found", id)));
        subject.setDeleted(true);
        subjectRepository.save(subject);
    }

    @Override
    public SubjectEntity save(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }

    @Override
    public SubjectEntity update(Long id, SubjectEntity subjectEntity) {
       subjectRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Subject with id %d wasn't found", id)));
        return subjectRepository.save(subjectEntity);
    }
}

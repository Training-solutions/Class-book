package com.eschool.classbook.subject;

import com.eschool.classbook.exception.ClassBookException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

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
    public Optional<SubjectEntity> findById(Long id) {
        return Optional.ofNullable(Optional.of(subjectRepository.getById(id))
                .orElseThrow(() -> new ClassBookException(String.format("Subject with id %d wasn't found", id))));
    }

    @Override
    public void deleteById(Long id) {
        SubjectEntity subject = Optional.of(subjectRepository.getById(id))
                .orElseThrow(() -> new ClassBookException(String.format("Subject with id %d wasn't found", id)));
        subject.setModifyingDate(LocalDateTime.now());
        subject.setDeleted(true);
        subjectRepository.save(subject);
    }

    @Override
    public SubjectEntity save(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }

    @Override
    public SubjectEntity update(Long id, SubjectEntity subjectEntity) {
        Optional.of(subjectRepository.getById(id))
                .orElseThrow(() -> new ClassBookException(String.format("Subject with id %d wasn't found", id)));
        subjectEntity.setModifyingDate(LocalDateTime.now());
        return subjectRepository.save(subjectEntity);
    }
}

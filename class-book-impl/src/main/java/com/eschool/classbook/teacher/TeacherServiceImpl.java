package com.eschool.classbook.teacher;

import com.eschool.classbook.exception.ClassBookException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Page<TeacherEntity> findAll(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Override
    public TeacherEntity findById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Teacher with id %d was not found", id)));
    }

    @Override
    public void deleteById(Long id) {
        TeacherEntity teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Teacher with id %d wasn't found", id)));
        teacher.setDeleted(true);
        teacher.getCredential().setDeleted(true);
        teacherRepository.save(teacher);
    }

    @Override
    public TeacherEntity save(TeacherEntity teacherEntity) {
        return teacherRepository.save(teacherEntity);
    }

    @Override
    public TeacherEntity update(Long id, TeacherEntity teacherEntity) {
        teacherRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Teacher with id %d wasn't found", id)));
        teacherEntity.setModifyingDate(LocalDateTime.now());
        return teacherRepository.save(teacherEntity);
    }
}

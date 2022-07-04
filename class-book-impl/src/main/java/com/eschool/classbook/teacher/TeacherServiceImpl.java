package com.eschool.classbook.teacher;

import com.eschool.classbook.exception.ClassBookException;
import com.eschool.classbook.subject.SubjectEntity;
import com.eschool.classbook.subject.SubjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

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
    public Optional<TeacherEntity> findById(Long id) {
        return Optional.ofNullable(Optional.of(teacherRepository.getById(id))
                .orElseThrow(() -> new ClassBookException(String.format("Teacher with id %d wasn't found", id))));
    }

    @Override
    public void deleteById(Long id) {
        TeacherEntity teacher = Optional.of(teacherRepository.getById(id))
                .orElseThrow(() -> new ClassBookException(String.format("Teacher with id %d wasn't found", id)));
        teacher.setModifyingDate(LocalDateTime.now());
        teacher.setDeleted(true);
        teacherRepository.save(teacher);
    }

    @Override
    public TeacherEntity save(TeacherEntity teacherEntity) {
        return teacherRepository.save(teacherEntity);
    }

    @Override
    public TeacherEntity update(Long id, TeacherEntity teacherEntity) {
        Optional.of(teacherRepository.getById(id))
                .orElseThrow(() -> new ClassBookException(String.format("Teacher with id %d wasn't found", id)));
        teacherEntity.setModifyingDate(LocalDateTime.now());
        return teacherRepository.save(teacherEntity);
    }
}

package com.eschool.classbook.student;

import com.eschool.classbook.exception.ClassBookException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Page<StudentEntity> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public StudentEntity findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Student with id %d was not found", id)));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Student with id %d wasn't found", id)));
        student.setDeleted(true);
        student.getCredential().setDeleted(true);
        studentRepository.save(student);
    }

    @Override
    public StudentEntity save(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    @Override
    public StudentEntity update(Long id, StudentEntity studentEntity) {
        studentRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Student with id %d wasn't found", id)));
        studentEntity.getCredential().setDeleted(true);
        return studentRepository.save(studentEntity);
    }
}


package com.eschool.classbook.student;


import com.eschool.openapi.v1.api.StudentsV1Api;
import com.eschool.openapi.v1.model.CommonResponseDto;
import com.eschool.openapi.v1.model.PageView;
import com.eschool.openapi.v1.model.StudentDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class StudentResource implements StudentsV1Api {
    private static final String STUDENT_SAVED_RESPONSE_TEXT = "Student with id - %d saved successfully";
    private static final String STUDENT_UPDATED_RESPONSE_TEXT = "Student with id - %d updated successfully";
    private static final String STUDENT_DELETED_RESPONSE_TEXT = "Student with id - %d deleted successfully";
    private final StudentMapper studentMapper;
    private final StudentService studentService;

    @Override
    public ResponseEntity<StudentDto> getStudentById(Long id) {
        StudentEntity studentEntity = studentService.findById(id);
        StudentDto studentDto = studentMapper.toDto(studentEntity);
        return ResponseEntity.ok(studentDto);
    }

    @Override
    public ResponseEntity<PageView<StudentDto>> getStudentList(Pageable pageable) {
        Page<StudentEntity> studentEntities = studentService.findAll(pageable);
        List<StudentDto> collect = studentEntities.getContent().stream().map(studentMapper::toDto).collect(Collectors.toList());
        PageView<StudentDto> pageView = new PageView<>();
        pageView.data(collect);
        return ResponseEntity.ok(pageView);
    }

    @Override
    public ResponseEntity<CommonResponseDto> postStudent(StudentDto studentDto) {
        StudentEntity studentEntity = studentMapper.toEntity(studentDto);
        StudentEntity savedStudent = studentService.save(studentEntity);
        Long id = savedStudent.getId();
        CommonResponseDto commonResponseDto = new CommonResponseDto(id, String.format(STUDENT_SAVED_RESPONSE_TEXT, id));
        return ResponseEntity.ok(commonResponseDto);
    }

    @Override
    public ResponseEntity<CommonResponseDto> updateStudent(Long id, StudentDto studentDto) {
        StudentEntity studentEntity = studentMapper.toEntity(studentDto);
        studentService.update(id, studentEntity);
        CommonResponseDto commonResponseDto = new CommonResponseDto(id, String.format(STUDENT_UPDATED_RESPONSE_TEXT, id));
        return ResponseEntity.ok(commonResponseDto);
    }

    @Override
    public ResponseEntity<CommonResponseDto> deleteStudent(Long id) {
        studentService.deleteById(id);
        CommonResponseDto commonResponseDto = new CommonResponseDto(id, String.format(STUDENT_DELETED_RESPONSE_TEXT, id));
        return ResponseEntity.ok(commonResponseDto);
    }
}

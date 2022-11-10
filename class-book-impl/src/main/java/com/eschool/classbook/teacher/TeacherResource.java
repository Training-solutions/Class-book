package com.eschool.classbook.teacher;

import com.eschool.openapi.v1.api.TeachersV1Api;
import com.eschool.openapi.v1.model.CommonResponseDto;
import com.eschool.openapi.v1.model.PageViewDto;
import com.eschool.openapi.v1.model.TeacherDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class TeacherResource implements TeachersV1Api {

    private static final String TEACHER_SAVED_RESPONSE_TEXT = "Teacher with id - %d saved successfully";
    private static final String TEACHER_UPDATE_RESPONSE_TEXT = "Teacher with id - %d updated successfully";
    private static final String TEACHER_DELETED_RESPONSE_TEXT = "Teacher with id - %d deleted successfully";

    private final TeacherMapper teacherMapper;
    private final TeacherService teacherService;
    @Override
    public ResponseEntity<CommonResponseDto> deleteTeacher(Long teacherId) {
        teacherService.deleteById(teacherId);
        CommonResponseDto commonResponseDto = new CommonResponseDto(teacherId, String.format(TEACHER_SAVED_RESPONSE_TEXT));
        return ResponseEntity.ok(commonResponseDto);
    }

    @Override
    public ResponseEntity<TeacherDto> getTeacherById(Long teacherId) {
        TeacherEntity teacherEntity = teacherService.findById(teacherId);
        TeacherDto teacherDto = teacherMapper.toDto(teacherEntity);
        return ResponseEntity.ok(teacherDto);
    }

    @Override
    public ResponseEntity<PageViewDto<TeacherDto>> getTeacherList(Pageable pageable) {
        Page<TeacherEntity> teacherEntities = teacherService.findAll(pageable);
        List<TeacherDto> collect = teacherEntities.getContent().stream().map(teacherMapper::toDto).collect(Collectors.toList());
        PageViewDto<TeacherDto> pageViewDto = new PageViewDto<>(collect);
        return ResponseEntity.ok(pageViewDto);
    }

    @Override
    public ResponseEntity<CommonResponseDto> postTeacher(TeacherDto teacherDto) {
        TeacherEntity teacherEntity = teacherMapper.toEntity(teacherDto);
        TeacherEntity savedTeacher = teacherService.save(teacherEntity);
        Long id = savedTeacher.getId();
        CommonResponseDto commonResponseDto = new CommonResponseDto(id, String.format(TEACHER_SAVED_RESPONSE_TEXT, id));
        return ResponseEntity.ok(commonResponseDto);
    }

    @Override
    public ResponseEntity<CommonResponseDto> updateTeacher(Long teacherId, TeacherDto teacherDto) {
        TeacherEntity teacherEntity = teacherMapper.toEntity(teacherDto);
        teacherService.update(teacherId, teacherEntity);
        CommonResponseDto commonResponseDto = new CommonResponseDto(teacherId, String.format(TEACHER_UPDATE_RESPONSE_TEXT, teacherId));
        return ResponseEntity.ok(commonResponseDto);
    }
}

package com.eschool.classbook.subject;

import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.group.GroupService;
import com.eschool.openapi.v1.api.SubjectsV1Api;
import com.eschool.openapi.v1.model.CommonResponseDto;
import com.eschool.openapi.v1.model.PageViewDto;
import com.eschool.openapi.v1.model.SubjectDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class SubjectResource implements SubjectsV1Api {

    private static final String SUBJECT_SAVED_RESPONSE_TEXT = "Subject with id - %d saved successfully";
    private static final String SUBJECT_UPDATE_RESPONSE_TEXT = "Subject with id - %d updated successfully";
    private static final String SUBJECT_DELETED_RESPONSE_TEXT = "Subject with id - %d deleted successfully";

    private final SubjectMapper subjectMapper;
    private final SubjectService subjectService;

    @Override
    public ResponseEntity<CommonResponseDto> deleteSubject(Long subjectId) {
        subjectService.deleteById(subjectId);
        CommonResponseDto commonResponseDto = new CommonResponseDto(subjectId, String.format(SUBJECT_DELETED_RESPONSE_TEXT, subjectId));
        return ResponseEntity.ok(commonResponseDto);
    }

    @Override
    public ResponseEntity<SubjectDto> getSubjectById(Long subjectId) {
        SubjectEntity subjectEntity = subjectService.findById(subjectId);
        SubjectDto subjectDto = subjectMapper.toDto(subjectEntity);
        return ResponseEntity.ok(subjectDto);
    }

    @Override
    public ResponseEntity<PageViewDto<SubjectDto>> getSubjectList(Pageable pageable) {
        Page<SubjectEntity> subjectEntities = subjectService.findAll(pageable);
        List<SubjectDto> collect = subjectEntities.getContent().stream().map(subjectMapper::toDto).collect(Collectors.toList());
        PageViewDto<SubjectDto> pageViewDto = new PageViewDto<>(collect);
        return ResponseEntity.ok(pageViewDto);
    }

    @Override
    public ResponseEntity<CommonResponseDto> postSubject(SubjectDto subjectDto) {
        SubjectEntity subjectEntity = subjectMapper.toEntity(subjectDto);
        SubjectEntity savedSubject = subjectService.save(subjectEntity);
        Long id = savedSubject.getId();
        CommonResponseDto commonResponseDto = new CommonResponseDto(id, String.format(SUBJECT_SAVED_RESPONSE_TEXT, id));
        return ResponseEntity.ok(commonResponseDto);
    }

    @Override
    public ResponseEntity<CommonResponseDto> updateSubject(Long subjectId, SubjectDto subjectDto) {
        SubjectEntity subjectEntity = subjectMapper.toEntity(subjectDto);
        subjectService.update(subjectId,subjectEntity);
        CommonResponseDto commonResponseDto = new CommonResponseDto(subjectId, String.format(SUBJECT_UPDATE_RESPONSE_TEXT, subjectId));
        return ResponseEntity.ok(commonResponseDto);
    }
}

package com.eschool.classbook.evaluationRecord;

import com.eschool.classbook.group.GroupEntity;
import com.eschool.openapi.v1.api.EvaluationRecordsV1Api;
import com.eschool.openapi.v1.model.EvaluationRecordDto;
import com.eschool.openapi.v1.model.PageViewDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class EvaluationRecordResource implements EvaluationRecordsV1Api {
    private final EvaluationRecordService evaluationRecordService;
    private final EvaluationRecordMapper evaluationRecordMapper;

    @Override
    public ResponseEntity<PageViewDto<EvaluationRecordDto>> getEvaluationRecords(Long subjectId, Long teacherId,
                                                                                 Long groupId, Long studentId,
                                                                                 OffsetDateTime startDate, OffsetDateTime endDate) {

        LocalDateTime startLocalDateTime = null;
        LocalDateTime endLocalDateTime = null;

        if (Objects.nonNull(startDate) && Objects.nonNull(endDate)) {
            startLocalDateTime =  evaluationRecordMapper.toLocalDateTime(startDate);
            endLocalDateTime = evaluationRecordMapper.toLocalDateTime(endDate);
        } else if (Objects.nonNull(startDate)){
            startLocalDateTime =  evaluationRecordMapper.toLocalDateTime(startDate);
            endLocalDateTime = LocalDateTime.now();
        }

        List<GroupEntity> evaluationRecords = evaluationRecordService
            .getEvaluationRecords(subjectId, teacherId, groupId, studentId, startLocalDateTime, endLocalDateTime);

        if (CollectionUtils.isEmpty(evaluationRecords)) {
            return ResponseEntity.noContent().build();
        }
        List<EvaluationRecordDto> recordDtos = evaluationRecords.stream()
                .map(evaluationRecordMapper::toDto)
                .collect(Collectors.toList());
        PageViewDto<EvaluationRecordDto> result = new PageViewDto<>(recordDtos);
        return ResponseEntity.ok(result);
    }
}

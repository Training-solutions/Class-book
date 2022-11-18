package com.eschool.classbook.evaluationRecord;

import com.eschool.classbook.BaseMapper;
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

@RestController
@AllArgsConstructor
public class EvaluationRecordResource implements EvaluationRecordsV1Api {
    private final EvaluationRecordService evaluationRecordService;
    private final BaseMapper baseMapper;

    @Override
    public ResponseEntity<PageViewDto<EvaluationRecordDto>> getEvaluationRecords(Long subjectId, Long teacherId,
                                                                                 Long groupId, Long studentId,
                                                                                 OffsetDateTime startDate, OffsetDateTime endDate) {
        LocalDateTime startLocalDateTime = baseMapper.toLocalDateTime(startDate);
        LocalDateTime endLocalDateTime = baseMapper.toLocalDateTime(endDate);
        List<EvaluationRecordDto> evaluationRecords = evaluationRecordService
            .getEvaluationRecords(subjectId, teacherId, groupId, studentId, startLocalDateTime, endLocalDateTime);
        if (CollectionUtils.isEmpty(evaluationRecords)) {
            return ResponseEntity.noContent().build();
        }
        PageViewDto<EvaluationRecordDto> result = new PageViewDto<>(evaluationRecords);
        return ResponseEntity.ok(result);
    }
}

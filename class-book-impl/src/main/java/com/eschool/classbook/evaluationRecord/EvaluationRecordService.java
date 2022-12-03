package com.eschool.classbook.evaluationRecord;

import com.eschool.classbook.group.GroupEntity;
import com.eschool.openapi.v1.model.EvaluationRecordDto;

import java.time.LocalDateTime;
import java.util.List;

public interface EvaluationRecordService {
    List<GroupEntity> getEvaluationRecords(Long subjectId, Long teacherId,
                                           Long groupId, Long studentId,
                                           LocalDateTime startDate, LocalDateTime endDate);
}

package com.eschool.classbook.evaluationRecord;

import com.eschool.openapi.v1.model.EvaluationRecordDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EvaluationRecordServiceImpl implements EvaluationRecordService {
    @Override
    public List<EvaluationRecordDto> getEvaluationRecords(Long subjectId, Long teacherId,
                                                          Long groupId, Long studentId,
                                                          LocalDateTime startDate, LocalDateTime endDate) {
        return null;
    }
}

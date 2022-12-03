package com.eschool.classbook.evaluationRecord;

import com.eschool.classbook.group.GroupEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EvaluationRecordServiceImpl implements EvaluationRecordService {
    private final EvaluationRecordRepository evaluationRecordRepository;

    public EvaluationRecordServiceImpl(EvaluationRecordRepository evaluationRecordRepository) {
        this.evaluationRecordRepository = evaluationRecordRepository;
    }

    @Override
    public List<GroupEntity> getEvaluationRecords(Long subjectId, Long teacherId,
                                                  Long groupId, Long studentId,
                                                  LocalDateTime startDate, LocalDateTime endDate) {
        return evaluationRecordRepository
                .getEvaluationRecords(subjectId, teacherId, groupId, studentId, startDate, endDate);
    }
}

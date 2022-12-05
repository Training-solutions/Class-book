package com.eschool.classbook.report;

import java.time.LocalDateTime;

public interface ReportService {
    byte[] getReport(Long subjectId, Long teacherId,
                     Long groupId, Long studentId,
                     LocalDateTime startDate, LocalDateTime endDate);
}

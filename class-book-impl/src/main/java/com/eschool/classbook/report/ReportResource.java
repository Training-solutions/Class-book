package com.eschool.classbook.report;

import com.eschool.openapi.v1.api.ReportV1Api;
import lombok.AllArgsConstructor;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Objects;

@RestController
@AllArgsConstructor
public class ReportResource implements ReportV1Api {
    private final ReportService reportService;
    private final ReportMapper reportMapper;

    @Override
    public ResponseEntity<?> getReports(Long subjectId, Long teacherId, Long groupId, Long studentId,
                                        OffsetDateTime startDate, OffsetDateTime endDate) {
        LocalDateTime startLocalDateTime = null;
        LocalDateTime endLocalDateTime = null;

        if (Objects.nonNull(startDate) && Objects.nonNull(endDate)) {
            startLocalDateTime =  reportMapper.toLocalDateTime(startDate);
            endLocalDateTime = reportMapper.toLocalDateTime(endDate);
        } else if (Objects.nonNull(startDate)) {
            startLocalDateTime =  reportMapper.toLocalDateTime(startDate);
            endLocalDateTime = LocalDateTime.now();
        }

        byte[] report = reportService.getReport(subjectId, teacherId, groupId, studentId,
            startLocalDateTime, endLocalDateTime);

        if (report.length > 0) {
            String sheetName;
            LocalDateTime time = LocalDateTime.now();
            if (startDate==null || endDate==null) {
                sheetName = String.format("%s_%tF-%tH_%tM", "Report", time, time, time);
            } else {
                sheetName = String.format("%s_%tF---%tF_%tF-%tH_%tM", "Report", startDate, endDate, time, time, time);
            }

            return ResponseEntity.ok()
                .header(
                    HttpHeaders.CONTENT_DISPOSITION,
                    ContentDisposition.builder("response").filename(sheetName + ".xlsx",
                        StandardCharsets.UTF_8).build().toString())
                .contentType(MediaType
                    .parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .contentLength(report.length)
                .body(report);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.eschool.classbook.report;

import com.eschool.classbook.evaluationRecord.EvaluationRecordService;
import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.mark.MarkEntity;
import com.eschool.classbook.student.StudentEntity;
import com.eschool.classbook.subject.SubjectEntity;
import com.eschool.classbook.teacher.TeacherEntity;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ReportServiceImpl implements ReportService {
    private final EvaluationRecordService evaluationRecordService;

    public ReportServiceImpl(EvaluationRecordService evaluationRecordService) {
        this.evaluationRecordService = evaluationRecordService;
    }

    @Override
    public byte[] getReport(Long subjectId, Long teacherId, Long groupId, Long studentId,
                            LocalDateTime startDate, LocalDateTime endDate) {
        List<GroupEntity> evaluationRecords = evaluationRecordService
            .getEvaluationRecords(subjectId, teacherId, groupId, studentId, startDate, endDate);

        if (!evaluationRecords.isEmpty()) {
            final boolean compressTempFiles = true; // compress the temporary file for creation
            final int rowAccessWindowSize = -1; // flush only at the end of creation!
            XSSFWorkbook workbook = new XSSFWorkbook();
            final SXSSFWorkbook sheets = new SXSSFWorkbook(workbook, rowAccessWindowSize, compressTempFiles);

            // Write you logic here. Use please methods below.


            // End of you logic. Code below will convert workbook you created into a byte array.
            // At the controller layer it will turn into a real excel file

            workbook.setActiveSheet(0);

            byte[] bytes;

            try {
                final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                sheets.write(outputStream);
                bytes = outputStream.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return bytes;
        }

        return new byte[0];
    }

    private List<XSSFSheet> createSheets (XSSFWorkbook workbook, Map<String, Set<SubjectEntity>> groupTitleSubjectMap) {
        return groupTitleSubjectMap.keySet()
            .stream()
            .flatMap(
                key -> groupTitleSubjectMap.get(key)
                    .stream()
                    .map(subjectEntity ->
                        workbook.createSheet(key + "_" + subjectEntity.getSubjectTitle())))
            .collect(Collectors.toList());
    }

    private Map<String, Set<SubjectEntity>> getGroupTitleSubjectMap (List<GroupEntity> evaluationRecords) {
        return evaluationRecords.stream()
            .collect(
                Collectors.toMap(
                    GroupEntity::getGroupTitle,
                    GroupEntity::getSubjects));
    }

    private void createHeaderRow(XSSFSheet sheet) {
        XSSFRow row = sheet.createRow(0);
        createCell("Student firstName", row, 0);
        createCell("Student lastName", row, 1);
        createCell("Teacher firstName", row, 2);
        createCell("Teacher lastName", row, 3);
        createCell("Mark", row, 4);
        createCell("Creation Date", row, 5);
        createCell("Modifying Date", row, 6);
    }

    private void createCell(String value, XSSFRow row, int number) {
        XSSFCell cell = row.createCell(number);
        cell.setCellValue(value);
    }
}

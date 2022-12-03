package com.eschool.classbook.evaluationRecord;

import com.eschool.classbook.BaseIntegrationTest;
import com.eschool.classbook.group.GroupEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EvaluationRecordServiceImplTest extends BaseIntegrationTest {
    @Autowired
    private EvaluationRecordService evaluationRecordService;

    @Test
    public void givenTeacherIdOnly_whenGetEvaluationRecords_thenResultSuccessful() {
        List<GroupEntity> evaluationRecords = evaluationRecordService.getEvaluationRecords(
                null, 1L, null, null, null, null);

        assertFalse(CollectionUtils.isEmpty(evaluationRecords));
        assertEquals(1, evaluationRecords.size());

        GroupEntity groupEntity = evaluationRecords.get(0);

        assertFalse(groupEntity.getTeachers().isEmpty());
        assertFalse(groupEntity.getStudents().isEmpty());
        assertFalse(groupEntity.getSubjects().isEmpty());
        assertEquals(Long.valueOf(1L), groupEntity.getId());
        assertEquals("2A", groupEntity.getGroupTitle());
        assertFalse(groupEntity.isDeleted());

        assertFalse(CollectionUtils.isEmpty(groupEntity.getStudents()));
        assertEquals(1, groupEntity.getStudents().size());

        assertTrue(groupEntity.getStudents().stream()
                .allMatch(studentEntity -> studentEntity.getId().equals(1L)));
    }
}

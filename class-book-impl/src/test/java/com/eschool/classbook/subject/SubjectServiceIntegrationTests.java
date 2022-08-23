package com.eschool.classbook.subject;

import com.eschool.classbook.BaseIntegrationTest;
import com.eschool.classbook.TestData;
import com.eschool.classbook.exception.ClassBookException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class SubjectServiceIntegrationTests extends BaseIntegrationTest {
    @Autowired
    private SubjectService subjectService;

    @Test
    public void givenSubject_whenSave_thenReturnSuccessfulResult() {
        //given
        SubjectEntity expected = TestData.getSubjectEntity();

        //when
        SubjectEntity actual = subjectService.save(expected);

        //then
        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getSubjectTitle(), actual.getSubjectTitle());

    }

    @Test
    public void givenSubject_whenFindById_thenReturnSuccessfulResult(){
        //when
        SubjectEntity actual = subjectService.findById(1L);

        //then
        assertNotNull(actual);
        assertEquals(Long.valueOf(1), actual.getId());
        assertEquals("MATH", actual.getSubjectTitle());
        assertFalse(actual.isDeleted());

    }

    @Test
    public void givenSubject_whenFindById_thenExceptionThrows(){
        //given
        Long failedId = 10L;

        //when and then
        assertThrows(String.format("Subject with id %d was not found", failedId),
                ClassBookException.class,
                () -> subjectService.findById(failedId));
    }

    @Test
    public void givenSubject_whenDeleteById_thenDeletedSuccessfully(){
        //given
        Long id = 1L;

        //when
        subjectService.deleteById(id);

        //then
        SubjectEntity subjectDeleted = subjectService.findById(id);
        assertTrue(subjectDeleted.isDeleted());
    }

}

package com.eschool.classbook.subject;

import com.eschool.classbook.BaseIntegrationTest;
import com.eschool.classbook.TestData;
import com.eschool.classbook.exception.ClassBookException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Objects;

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

    @Test
    public void givenSubject_whenFindAll_thenFoundGroupListSuccessfully(){
        //when
        Page<SubjectEntity> actual = subjectService.findAll(PageRequest.of(1, 4));

        //then
        assertEquals(1, actual.getTotalPages());
        assertEquals(4, actual.getTotalElements());
        assertTrue(actual.stream().allMatch(Objects::nonNull));
    }

    @Test
    public void givenSubject_whenUpdate_thenUpdatedSuccessfully(){
        //given
        String subjectTitle = "Programming";
        Long id = 1L;
        SubjectEntity expexted = subjectService.findById(id);
        expexted.setSubjectTitle(subjectTitle);


        //when
        SubjectEntity actual = subjectService.update(id, expexted);

        //then
        assertEquals(subjectTitle, actual.getSubjectTitle());
    }

}

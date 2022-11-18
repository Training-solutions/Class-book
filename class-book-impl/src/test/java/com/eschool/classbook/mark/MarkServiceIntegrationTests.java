package com.eschool.classbook.mark;

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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class MarkServiceIntegrationTests extends BaseIntegrationTest {
    @Autowired
    private MarkService markService;

    @Test
    public void givenScore_whenSave_thenReturnSuccessfulResult() {
        //given
        MarkEntity expected = TestData.getScoreEntity();

        //when
        MarkEntity actual = markService.save(expected);

        //then
        assertNotNull(actual);
        assertEquals(expected.getMark(), actual.getMark());
        assertEquals(expected.getId(), actual.getId());
        assertFalse(expected.isDeleted());
        assertNull(expected.getSubject());

    }

    @Test
    public void givenScore_whenFindById_thenReturnSuccessfulResult() {
        //when
        MarkEntity actual = markService.findById(1L);

        //then
        assertNotNull(actual);
        assertEquals(Long.valueOf(1), actual.getId());
        assertEquals(11, actual.getMark().getValue());
        assertFalse(actual.isDeleted());

    }

    @Test
    public void givenScore_whenFindById_thenExceptionThrows() {
        //given
        Long failedId = 999L;

        //when and then
        assertThrows(String.format("Score with id %d was not found", failedId),
                ClassBookException.class,
                () -> markService.findById(failedId));
    }

    @Test
    public void givenScore_whenDeleteById_thenDeletedSuccessfully(){
        //given
        Long id = 1L;

        //when
        markService.deleteById(id);

        //then
        MarkEntity markEntity = markService.findById(id);
        assertTrue(markEntity.isDeleted());

    }

    @Test
    public void givenScore_whenFindAll_thenFoundGroupListSuccessfully(){
        //when
        Page<MarkEntity> scores = markService.findAll(PageRequest.of(1, 3));

        //then
        assertEquals(1, scores.getTotalPages());
        assertEquals(3, scores.getTotalElements());
        assertTrue(scores.stream().allMatch(Objects::nonNull));

    }

    @Test
    public void givenScore_whenUpdate_thenUpdatedSuccessfully(){
        //given

        Mark mark = Mark.ONE;
        MarkEntity expected = markService.findById(1L);
        expected.setMark(mark);

        //when
        markService.update(1L, expected);

        //then
        assertEquals(expected.getMark(), mark);

    }

}

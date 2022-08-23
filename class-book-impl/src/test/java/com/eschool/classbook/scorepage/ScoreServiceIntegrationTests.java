package com.eschool.classbook.scorepage;

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

public class ScoreServiceIntegrationTests extends BaseIntegrationTest {
    @Autowired
    private ScoreService scoreService;

    @Test
    public void givenScore_whenSave_thenReturnSuccessfulResult() {
        //given
        ScoreEntity expected = TestData.getScore();

        //when
        ScoreEntity actual = scoreService.save(expected);

        //then
        assertNotNull(actual);
        assertEquals(expected.getScore(), actual.getScore());
        assertEquals(expected.getId(), actual.getId());
        assertFalse(expected.isDeleted());
        assertTrue(expected.getSubjects().isEmpty());

    }

    @Test
    public void givenScore_whenFindById_thenReturnSuccessfulResult() {
        //when
        ScoreEntity actual = scoreService.findById(1L);

        //then
        assertNotNull(actual);
        assertEquals(Long.valueOf(1), actual.getId());
        assertEquals(11, actual.getScore().getValue());
        assertFalse(actual.isDeleted());

    }

    @Test
    public void givenScore_whenFindById_thenExceptionThrows() {
        //given
        Long failedId = 999L;

        //when and then
        assertThrows(String.format("Score with id %d was not found", failedId),
                ClassBookException.class,
                () -> scoreService.findById(failedId));
    }

    @Test
    public void givenScore_whenDeleteById_thenDeletedSuccessfully(){
        //given
        Long id = 1L;

        //when
        scoreService.deleteById(id);

        //then
        ScoreEntity scoreEntity = scoreService.findById(id);
        assertTrue(scoreEntity.isDeleted());

    }

    @Test
    public void givenScore_whenFindAll_thenFoundGroupListSuccessfully(){
        //when
        Page<ScoreEntity> scores = scoreService.findAll(PageRequest.of(1, 3));

        //then
        assertEquals(1, scores.getTotalPages());
        assertEquals(3, scores.getTotalElements());
        assertTrue(scores.stream().allMatch(Objects::nonNull));

    }

    @Test
    public void givenScore_whenUpdate_thenUpdatedSuccessfully(){
        //given

        Score score = Score.ONE;
        ScoreEntity expected = scoreService.findById(1L);
        expected.setScore(score);

        //when
        scoreService.update(1L, expected);

        //then
        assertEquals(expected.getScore(), score);

    }

}

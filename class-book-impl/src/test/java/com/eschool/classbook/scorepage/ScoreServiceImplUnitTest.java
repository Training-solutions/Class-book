package com.eschool.classbook.scorepage;

import com.eschool.classbook.TestData;
import com.eschool.classbook.exception.ClassBookException;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ScoreServiceImplUnitTest {
    private ScoreRepository scoreRepository = mock(ScoreRepository.class);

    private final ScoreService scoreService = new ScoreServiceImpl(scoreRepository);

    @Test
    public void givenScore_whenSave_thenReturnSuccessfulResult() {
        //given
        ScoreEntity scoreEntity = TestData.getScoreEntity();
        scoreEntity.setId(null);
        ScoreEntity expected = TestData.getScoreEntity();
        when(scoreRepository.save(eq(scoreEntity))).thenReturn(expected);

        //when
        ScoreEntity actual = scoreService.save(scoreEntity);

        //then
        verify(scoreRepository, times(1)).save(eq(scoreEntity));
    }

    @Test
    public void givenScore_whenFindById_thenReturnSuccessfulResult(){
        //given
        ScoreEntity expected = TestData.getScoreEntity();
        Long id = expected.getId();
        when(scoreRepository.findById(eq(id))).thenReturn(Optional.of(expected));

        //when
        ScoreEntity actual = scoreService.findById(id);

        //then
        verify(scoreRepository, times(1)).findById(eq(id));
    }

    @Test
    public void givenScore_whenFindById_thenThrowsException(){
        //given
        ScoreEntity scoreEntity = TestData.getScoreEntity();
        Long id = scoreEntity.getId();
        when(scoreRepository.findById(eq(id))).thenReturn(Optional.of(scoreEntity));
        Long failedId = 2L;

        //when
        assertThrows(String.format("Score with id %d was not found", failedId),
                ClassBookException.class,
                ()->scoreService.findById(failedId));

        //then
        verify(scoreRepository, times(1)).findById(eq(failedId));

    }

    @Test
    public void givenScore_whenDeleteById_thenDeletedSuccessfully(){
        //given
        ScoreEntity scoreEntity = TestData.getScoreEntity();
        Long id = scoreEntity.getId();
        ScoreEntity expected = TestData.getScoreEntity();
        expected.setDeleted(true);

        when(scoreRepository.findById(eq(id))).thenReturn(Optional.of(scoreEntity));
        when(scoreRepository.save(eq(scoreEntity))).thenReturn(expected);

        //when
        scoreService.deleteById(id);

        //then
        verify(scoreRepository, times(1)).findById(id);
        verify(scoreRepository, times(1)).save(scoreEntity);

    }

    @Test
    public void givenScoreList_whenFindAll_thenFoundScoreListSuccessfully(){
        //given
        ScoreEntity scoreEntity = TestData.getScoreEntity();
        List<ScoreEntity> expected = List.of(scoreEntity);
        when(scoreRepository.findAll()).thenReturn(expected);

        //when
        Page<ScoreEntity> actual = scoreService.findAll(Pageable.unpaged());

        verify(scoreRepository, times(1)).findAll(eq(Pageable.unpaged()));

    }
    @Test
    public void givenScore_whenUpdate_thenUpdatedSuccessfully(){
        //given
        ScoreEntity scoreEntity = TestData.getScoreEntity();
        Long id = scoreEntity.getId();
        ScoreEntity expected = TestData.getScoreEntity();
        expected.setScore(Score.TEN);
        when(scoreRepository.findById(eq(id))).thenReturn(Optional.of(scoreEntity));
        when(scoreRepository.save(eq(scoreEntity))).thenReturn(expected);

        //when
        scoreService.update(id, scoreEntity);

        //then
        verify(scoreRepository, times(1)).findById(eq(id));
        verify(scoreRepository, times(1)).save(eq(scoreEntity));
    }
}

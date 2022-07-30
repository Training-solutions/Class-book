package com.eschool.classbook.scorepage;

import com.eschool.classbook.TestData;
import com.eschool.classbook.exception.ClassBookException;
import com.eschool.classbook.group.GroupEntity;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertThrows;

public class ScorepageServiceImplUnitTest {
    private ScoreRepository scoreRepository = mock(ScoreRepository.class);

    private final ScoreService scoreService = new ScoreServiceImpl(scoreRepository);

    @Test
    public void givenScorepage_whenSave_thenReturnSuccessfulResult() {
        //given
        ScoreEntity scoreEntity = TestData.getScore();
        scoreEntity.setId(null);
        ScoreEntity expected = TestData.getScore();
        when(scoreRepository.save(eq(scoreEntity))).thenReturn(expected);

        //when
        ScoreEntity actual = scoreService.save(scoreEntity);

        //then
        Mockito.verify(scoreRepository, times(1)).save(eq(scoreEntity));
    }

    @Test
    public void givenScorepage_whenFindById_thenReturnSuccessfulResult(){
        //given
        ScoreEntity expected = TestData.getScore();
        Long id = expected.getId();
        when(scoreRepository.findById(eq(id))).thenReturn(Optional.of(expected));

        //when
        ScoreEntity actual = scoreService.findById(id);

        //then
        verify(scoreRepository, times(1)).findById(eq(id));
    }

    @Test
    public void givenScorepage_whenFindById_thenThrowsException(){
        //given
        ScoreEntity scoreEntity = TestData.getScore();
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
    public void givenScorepage_whenDeleteById_thenDeletedSuccessfully(){
        //given
        ScoreEntity scoreEntity = TestData.getScore();
        Long id = scoreEntity.getId();
        ScoreEntity expected = TestData.getScore();
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
    public void givenScorepageList_whenFindAll_thenFoundScorepageListSuccessfully(){
        //given
        ScoreEntity scoreEntity = TestData.getScore();
        List<ScoreEntity> expected = List.of(scoreEntity);
        when(scoreRepository.findAll()).thenReturn(expected);

        //when
        Page<ScoreEntity> actual = scoreService.findAll(Pageable.unpaged());

        verify(scoreRepository, times(1)).findAll(eq(Pageable.unpaged()));

    }
    @Test
    public void givenScorepage_whenUpdate_thenUpdatedSuccessfully(){
        //given
        ScoreEntity scoreEntity = TestData.getScore();
        Long id = scoreEntity.getId();
        ScoreEntity expected = TestData.getScore();
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

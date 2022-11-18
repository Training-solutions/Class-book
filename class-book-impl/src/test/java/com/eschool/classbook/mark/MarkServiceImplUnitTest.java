package com.eschool.classbook.mark;

import com.eschool.classbook.TestData;
import com.eschool.classbook.exception.ClassBookException;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MarkServiceImplUnitTest {
    private MarkRepository markRepository = mock(MarkRepository.class);

    private final MarkService markService = new MarkServiceImpl(markRepository);

    @Test
    public void givenScore_whenSave_thenReturnSuccessfulResult() {
        //given
        MarkEntity markEntity = TestData.getScoreEntity();
        markEntity.setId(null);
        MarkEntity expected = TestData.getScoreEntity();
        when(markRepository.save(eq(markEntity))).thenReturn(expected);

        //when
        MarkEntity actual = markService.save(markEntity);

        //then
        verify(markRepository, times(1)).save(eq(markEntity));
    }

    @Test
    public void givenScore_whenFindById_thenReturnSuccessfulResult(){
        //given
        MarkEntity expected = TestData.getScoreEntity();
        Long id = expected.getId();
        when(markRepository.findById(eq(id))).thenReturn(Optional.of(expected));

        //when
        MarkEntity actual = markService.findById(id);

        //then
        verify(markRepository, times(1)).findById(eq(id));
    }

    @Test
    public void givenScore_whenFindById_thenThrowsException(){
        //given
        MarkEntity markEntity = TestData.getScoreEntity();
        Long id = markEntity.getId();
        when(markRepository.findById(eq(id))).thenReturn(Optional.of(markEntity));
        Long failedId = 2L;

        //when
        assertThrows(String.format("Score with id %d was not found", failedId),
                ClassBookException.class,
                ()-> markService.findById(failedId));

        //then
        verify(markRepository, times(1)).findById(eq(failedId));

    }

    @Test
    public void givenScore_whenDeleteById_thenDeletedSuccessfully(){
        //given
        MarkEntity markEntity = TestData.getScoreEntity();
        Long id = markEntity.getId();
        MarkEntity expected = TestData.getScoreEntity();
        expected.setDeleted(true);

        when(markRepository.findById(eq(id))).thenReturn(Optional.of(markEntity));
        when(markRepository.save(eq(markEntity))).thenReturn(expected);

        //when
        markService.deleteById(id);

        //then
        verify(markRepository, times(1)).findById(id);
        verify(markRepository, times(1)).save(markEntity);

    }

    @Test
    public void givenScoreList_whenFindAll_thenFoundScoreListSuccessfully(){
        //given
        MarkEntity markEntity = TestData.getScoreEntity();
        List<MarkEntity> expected = List.of(markEntity);
        when(markRepository.findAll()).thenReturn(expected);

        //when
        Page<MarkEntity> actual = markService.findAll(Pageable.unpaged());

        verify(markRepository, times(1)).findAll(eq(Pageable.unpaged()));

    }
    @Test
    public void givenScore_whenUpdate_thenUpdatedSuccessfully(){
        //given
        MarkEntity markEntity = TestData.getScoreEntity();
        Long id = markEntity.getId();
        MarkEntity expected = TestData.getScoreEntity();
        expected.setMark(Mark.TEN);
        when(markRepository.findById(eq(id))).thenReturn(Optional.of(markEntity));
        when(markRepository.save(eq(markEntity))).thenReturn(expected);

        //when
        markService.update(id, markEntity);

        //then
        verify(markRepository, times(1)).findById(eq(id));
        verify(markRepository, times(1)).save(eq(markEntity));
    }
}

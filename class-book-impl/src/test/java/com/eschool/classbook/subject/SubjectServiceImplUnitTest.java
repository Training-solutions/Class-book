package com.eschool.classbook.subject;

import com.eschool.classbook.TestData;
import com.eschool.classbook.exception.ClassBookException;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class SubjectServiceImplUnitTest {
    private SubjectRepository subjectRepository = mock(SubjectRepository.class);

    private final SubjectService subjectService = new SubjectServiceImpl(subjectRepository);

    @Test
    public void givenSubject_whenSave_thenReturnSuccessfulResult() {
        //given
        SubjectEntity subjectEntity = TestData.getSubjectEntity();
        subjectEntity.setId(null);
        SubjectEntity expected = TestData.getSubjectEntity();
        when(subjectRepository.save(eq(subjectEntity))).thenReturn(expected);

        //when
        SubjectEntity actual = subjectService.save(subjectEntity);

        //then
        Mockito.verify(subjectRepository, times(1)).save(eq(subjectEntity));
    }

    @Test
    public void givenSubject_whenFindById_thenReturnSuccessfulResult(){
        //given
        SubjectEntity expected = TestData.getSubjectEntity();
        Long id = expected.getId();
        when(subjectRepository.findById(eq(id))).thenReturn(Optional.of(expected));

        //when
        SubjectEntity actual = subjectService.findById(id);

        //then
        verify(subjectRepository, times(1)).findById(eq(id));
    }

    @Test
    public void givenSubject_whenFindById_thenThrowsException(){
        //given
        SubjectEntity subjectEntity = TestData.getSubjectEntity();
        Long id = subjectEntity.getId();
        when(subjectRepository.findById(eq(id))).thenReturn(Optional.of(subjectEntity));
        Long failedId = 2L;

        //when
        assertThrows(String.format("Subject with id %d was not found", failedId),
                ClassBookException.class,
                ()->subjectService.findById(failedId));

        //then
        verify(subjectRepository, times(1)).findById(eq(failedId));

    }

    @Test
    public void givenSubject_whenDeleteById_thenDeletedSuccessfully(){
        //given
        SubjectEntity subjectEntity = TestData.getSubjectEntity();
        Long id = subjectEntity.getId();
        SubjectEntity expected = TestData.getSubjectEntity();
        expected.setDeleted(true);

        when(subjectRepository.findById(eq(id))).thenReturn(Optional.of(subjectEntity));
        when(subjectRepository.save(eq(subjectEntity))).thenReturn(expected);

        //when
        subjectService.deleteById(id);

        //then
        verify(subjectRepository, times(1)).findById(id);
        verify(subjectRepository, times(1)).save(subjectEntity);

    }

    @Test
    public void givenSubjectList_whenFindAll_thenFoundSubjectListSuccessfully(){
        //given
        SubjectEntity subjectEntity = TestData.getSubjectEntity();
        List<SubjectEntity> expected = List.of(subjectEntity);
        when(subjectRepository.findAll()).thenReturn(expected);

        //when
        Page<SubjectEntity> actual = subjectService.findAll(Pageable.unpaged());

        verify(subjectRepository, times(1)).findAll(eq(Pageable.unpaged()));

    }

    @Test
    public void givenSubject_whenUpdate_thenUpdatedSuccessfully(){
        //given
        SubjectEntity subjectEntity = TestData.getSubjectEntity();
        Long id = subjectEntity.getId();
        SubjectEntity expected = TestData.getSubjectEntity();
        expected.setSubjectTitle("Some text...");
        when(subjectRepository.findById(eq(id))).thenReturn(Optional.of(subjectEntity));
        when(subjectRepository.save(eq(subjectEntity))).thenReturn(expected);

        //when
        subjectService.update(id, subjectEntity);

        //then
        verify(subjectRepository, times(1)).findById(eq(id));
        verify(subjectRepository, times(1)).save(eq(subjectEntity));
    }
}

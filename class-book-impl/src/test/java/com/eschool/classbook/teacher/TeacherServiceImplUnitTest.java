package com.eschool.classbook.teacher;

import com.eschool.classbook.TestData;
import com.eschool.classbook.credential.CredentialEntity;
import com.eschool.classbook.exception.ClassBookException;
import org.junit.Test;
import org.mockito.Mockito;
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

public class TeacherServiceImplUnitTest {
    private TeacherRepository teacherRepository = mock(TeacherRepository.class);

    private final TeacherService teacherService = new TeacherServiceImpl(teacherRepository);

    @Test
    public void givenTeacher_whenSave_thenReturnSuccessfulResult() {
        //given
        TeacherEntity teacherEntity = TestData.getTeacherEntity();
        teacherEntity.setId(null);
        TeacherEntity expected = TestData.getTeacherEntity();
        when(teacherRepository.save(eq(teacherEntity))).thenReturn(expected);

        //when
        TeacherEntity actual = teacherService.save(teacherEntity);

        //then
        Mockito.verify(teacherRepository, times(1)).save(eq(teacherEntity));

    }

    @Test
    public void givenTeacher_whenFindById_thenReturnSuccessfulResult(){
        //given
        TeacherEntity expected = TestData.getTeacherEntity();
        Long id = expected.getId();
        when(teacherRepository.findById(eq(id))).thenReturn(Optional.of(expected));

        //when
        TeacherEntity actual = teacherService.findById(id);

        //then
        verify(teacherRepository, times(1)).findById(eq(id));
    }

    @Test
    public void givenTeacher_whenFindById_thenThrowsException(){
        //given
        TeacherEntity teacherEntity = TestData.getTeacherEntity();
        Long id = teacherEntity.getId();
        when(teacherRepository.findById(eq(id))).thenReturn(Optional.of(teacherEntity));
        Long failedId = 2L;

        //when
        assertThrows(String.format("Teacher with id %d was not found", failedId),
                ClassBookException.class,
                ()->teacherService.findById(failedId));

        //then
        verify(teacherRepository, times(1)).findById(eq(failedId));

    }

    @Test
    public void givenTeacher_whenDeleteById_thenDeletedSuccessfully(){
        //given
        TeacherEntity teacherEntity = TestData.getTeacherEntity();
        Long id = teacherEntity.getId();
        CredentialEntity credentialEntity = TestData.getCredentialEntity();
        teacherEntity.setCredential(credentialEntity);
        TeacherEntity expected = TestData.getTeacherEntity();
        expected.setDeleted(true);

        when(teacherRepository.findById(eq(id))).thenReturn(Optional.of(teacherEntity));
        when(teacherRepository.save(eq(teacherEntity))).thenReturn(expected);

        //when
        teacherService.deleteById(id);

        //then
        verify(teacherRepository, times(1)).findById(id);
        verify(teacherRepository, times(1)).save(teacherEntity);

    }

    @Test
    public void givenTeacherList_whenFindAll_thenFoundTeacherListSuccessfully(){
        //given
        TeacherEntity teacherEntity = TestData.getTeacherEntity();
        List<TeacherEntity> expected = List.of(teacherEntity);
        when(teacherRepository.findAll()).thenReturn(expected);

        //when
        Page<TeacherEntity> actual = teacherService.findAll(Pageable.unpaged());

        verify(teacherRepository, times(1)).findAll(eq(Pageable.unpaged()));

    }

    @Test
    public void givenTeacher_whenUpdate_thenUpdatedSuccessfully(){
        //given
        TeacherEntity teacherEntity = TestData.getTeacherEntity();
        Long id = teacherEntity.getId();
        TeacherEntity expected = TestData.getTeacherEntity();
        expected.setFirstName("Some text...");
        when(teacherRepository.findById(eq(id))).thenReturn(Optional.of(teacherEntity));
        when(teacherRepository.save(eq(teacherEntity))).thenReturn(expected);

        //when
        teacherService.update(id, teacherEntity);

        //then
        verify(teacherRepository, times(1)).findById(eq(id));
        verify(teacherRepository, times(1)).save(eq(teacherEntity));
    }

}

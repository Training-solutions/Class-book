package com.eschool.classbook.teacher;

import com.eschool.classbook.TestData;
import com.eschool.classbook.exception.ClassBookException;
import com.eschool.openapi.v1.api.TeachersV1Api;
import com.eschool.openapi.v1.model.CommonResponseDto;
import com.eschool.openapi.v1.model.PageViewDto;
import com.eschool.openapi.v1.model.TeacherDto;
import org.junit.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class TeacherResourceUnitTest {
    private final TeacherService teacherService = mock(TeacherService.class);
    private final TeacherMapper teacherMapper = mock(TeacherMapper.class);
    private final TeachersV1Api teacherResource = new TeacherResource(teacherMapper, teacherService);

    @Test
    public void givenTeacher_whenSave_thenTeacherSavedSuccessfully(){
        //given
        TeacherEntity teacherEntity = TestData.getTeacherEntity();
        TeacherEntity expected = TestData.getTeacherEntity();
        TeacherDto teacherDto = TestData.getTeacherDto();

        when(teacherMapper.toEntity(eq(teacherDto))).thenReturn(teacherEntity);
        when(teacherService.save(eq(teacherEntity))).thenReturn(expected);

        //when
        ResponseEntity<CommonResponseDto> response = teacherResource.postTeacher(teacherDto);

        //then
        verify(teacherMapper, times(1)).toEntity(eq(teacherDto));
        verify(teacherService, times(1)).save(eq(teacherEntity));
    }

    @Test
    public void givenTeacher_whenFindById_thenTeacherFoundSuccessfully(){
        //given
        TeacherEntity teacherEntity = TestData.getTeacherEntity();
        Long id = teacherEntity.getId();
        TeacherDto teacherDto = TestData.getTeacherDto();

        when(teacherService.findById(eq(id))).thenReturn(teacherEntity);
        when(teacherMapper.toDto(teacherEntity)).thenReturn(teacherDto);

        //when
        ResponseEntity<TeacherDto> response = teacherResource.getTeacherById(id);

        //then
        verify(teacherService, times(1)).findById(eq(id));
        verify(teacherMapper, times(1)).toDto(teacherEntity);
    }

    @Test
    public void givenTeacher_whenFindById_thenExceptionThrows(){
        //given
        Long failedId = 2L;

        when(teacherService.findById(failedId))
                .thenThrow(new ClassBookException(String.format("Teacher with id %d was not found", failedId)));

        //when and then
        assertThrows(
                String.format("Teacher with id %d was not found", failedId),
                ClassBookException.class,
                () -> teacherResource.getTeacherById(failedId)
        );
    }

    @Test
    public void givenTeachersList_whenFindAll_thenFoundTeacherListSuccessfully(){
        //given
        TeacherEntity teacherEntity = TestData.getTeacherEntity();
        List<TeacherEntity> expected = List.of(teacherEntity);
        PageRequest pageRequest = PageRequest.of(1, 10);

        when(teacherService.findAll(eq(pageRequest))).thenReturn(new PageImpl<>(expected));


        //when
        ResponseEntity<PageViewDto<TeacherDto>> response = teacherResource.getTeacherList(pageRequest);

        //then
        verify(teacherService, times(1)).findAll(eq(pageRequest));
        verify(teacherMapper, times(1)).toDto(teacherEntity);
    }

    @Test
    public void givenTeacher_whenUpdate_thenTeacherUpdatedSuccessfully(){
        //given
        TeacherEntity teacherEntity = TestData.getTeacherEntity();
        Long id = teacherEntity.getId();
        TeacherEntity expected = TestData.getTeacherEntity();
        expected.setFirstName("Some name");
        TeacherDto teacherDto = TestData.getTeacherDto();
        when(teacherService.update(eq(id), teacherEntity)).thenReturn(expected);
        when(teacherMapper.toEntity(teacherDto)).thenReturn(teacherEntity);

        //when
        ResponseEntity<CommonResponseDto> response = teacherResource.updateTeacher(id, teacherDto);

        //then
        verify(teacherService, times(1)).update(eq(id), eq(teacherEntity));
        verify(teacherMapper, times(1)).toEntity(teacherDto);

    }

    @Test
    public void givenTeacher_whenDelete_thenTeacherDeletedSuccessfully(){
        //given
        TeacherEntity teacherEntity = TestData.getTeacherEntity();
        Long id = teacherEntity.getId();
        TeacherEntity expected = TestData.getTeacherEntity();
        expected.setDeleted(true);
        doNothing().when(teacherService).deleteById(id);

        //when
        ResponseEntity<CommonResponseDto> response = teacherResource.deleteTeacher(id);

        //then
        verify(teacherService, times(1)).deleteById(eq(id));
    }
}

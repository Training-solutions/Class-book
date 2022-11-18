package com.eschool.classbook.subject;

import com.eschool.classbook.TestData;
import com.eschool.classbook.exception.ClassBookException;
import com.eschool.openapi.v1.api.SubjectsV1Api;
import com.eschool.openapi.v1.model.CommonResponseDto;
import com.eschool.openapi.v1.model.PageViewDto;
import com.eschool.openapi.v1.model.SubjectDto;
import org.junit.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SubjectResourceUnitTest {
    private final SubjectService subjectService = mock(SubjectService.class);
    private final SubjectMapper subjectMapper = mock(SubjectMapper.class);
    private final SubjectsV1Api subjectResource = new SubjectResource(subjectMapper, subjectService);

    @Test
    public void givenSubject_whenSave_thenSubjectSavedSuccessfully(){
        //given
        SubjectEntity subjectEntity = TestData.getSubjectEntity();
        SubjectEntity expected = TestData.getSubjectEntity();
        SubjectDto subjectDto = TestData.getSubjectDto();

        when(subjectMapper.toEntity(eq(subjectDto))).thenReturn(subjectEntity);
        when(subjectService.save(eq(subjectEntity))).thenReturn(expected);

        //when
        ResponseEntity<CommonResponseDto> response = subjectResource.postSubject(subjectDto);

        //then
        verify(subjectService, times(1)).save(eq(subjectEntity));
        verify(subjectMapper, times(1)).toEntity(eq(subjectDto));
    }

    @Test
    public void givenSubject_whenFindById_thenSubjectFoundSuccessfully(){
        //given
        SubjectEntity expected = TestData.getSubjectEntity();
        Long id = expected.getId();
        SubjectDto subjectDto = TestData.getSubjectDto();

        when(subjectService.findById(eq(id))).thenReturn(expected);
        when(subjectMapper.toDto(expected)).thenReturn(subjectDto);

        //when
        ResponseEntity<SubjectDto> response = subjectResource.getSubjectById(id);

        //then
        verify(subjectService, times(1)).findById(eq(id));
        verify(subjectMapper, times(1)).toDto(expected);
    }

    @Test
    public void givenSubject_whenFindById_thenExceptionThrows(){
        //given
        Long failedId = 2L;

        when(subjectService.findById(failedId))
                .thenThrow(new ClassBookException(String.format("Subject with id %d was not found", failedId)));

        //when and then
        assertThrows(
                String.format("Subject with id %d was not found", failedId),
                ClassBookException.class,
                ()-> subjectResource.getSubjectById(failedId)
        );

        verify(subjectService, times(1)).findById(eq(failedId));
    }

    @Test
    public void givenSubjectList_whenFindAll_thenFoundSubjectListSuccessfully(){
        //given
        SubjectEntity subjectEntity = TestData.getSubjectEntity();
        List<SubjectEntity> expected = List.of(subjectEntity);
        PageRequest pageRequest = PageRequest.of(1, 10);
        when(subjectService.findAll(eq(pageRequest))).thenReturn(new PageImpl<>(expected));

        //when
        ResponseEntity<PageViewDto<SubjectDto>> response = subjectResource.getSubjectList(pageRequest);

        //then
        verify(subjectService, times(1)).findAll(eq(pageRequest));
        verify(subjectMapper, times(1)).toDto(subjectEntity);
    }

    @Test
    public void givenSubject_whenUpdate_thenSubjectUpdatedSuccessfully(){
        //given
        SubjectEntity subjectEntity = TestData.getSubjectEntity();
        Long id = subjectEntity.getId();
        SubjectEntity expected = TestData.getSubjectEntity();
        expected.setSubjectTitle("Some text");
        SubjectDto subjectDto = TestData.getSubjectDto();
        when(subjectService.update(eq(id), eq(subjectEntity))).thenReturn(expected);
        when(subjectMapper.toEntity(subjectDto)).thenReturn(subjectEntity);

        //when
        ResponseEntity<CommonResponseDto> response = subjectResource.updateSubject(id, subjectDto);

        //then
        verify(subjectService, times(1)).update(eq(id), eq(subjectEntity));
        verify(subjectMapper, times(1)).toEntity(subjectDto);
    }

    @Test
    public void givenSubject_whenDelete_thenSubjectDeletedSuccessfully(){
        //given
        SubjectEntity subjectEntity = TestData.getSubjectEntity();
        Long id = subjectEntity.getId();
        SubjectEntity expected = TestData.getSubjectEntity();
        expected.setDeleted(true);
        doNothing().when(subjectService).deleteById(id);


        //when
        ResponseEntity <CommonResponseDto> response = subjectResource.deleteSubject(id);

        //then
        verify(subjectService, times(1)).deleteById(id);
    }
}

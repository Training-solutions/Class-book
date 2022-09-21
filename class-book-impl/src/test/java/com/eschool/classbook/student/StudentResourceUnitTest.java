package com.eschool.classbook.student;

import com.eschool.classbook.TestData;
import com.eschool.classbook.exception.ClassBookException;
import com.eschool.openapi.v1.api.StudentsV1Api;
import com.eschool.openapi.v1.model.CommonResponseDto;
import com.eschool.openapi.v1.model.PageViewDto;
import com.eschool.openapi.v1.model.StudentDto;
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

public class StudentResourceUnitTest {
    private final StudentService studentService = mock(StudentService.class);
    private final StudentMapper studentMapper = mock(StudentMapper.class);
    private final StudentsV1Api studentResource = new StudentResource(studentMapper, studentService);

    @Test
    public void givenStudent_whenSave_thenStudentSavedSuccessfully(){
        //given
        StudentEntity studentEntity = TestData.getStudentEntity();
        StudentEntity expected = TestData.getStudentEntity();
        StudentDto studentDto = TestData.getStudentDto();
        when(studentMapper.toEntity(eq(studentDto))).thenReturn(studentEntity);
        when(studentService.save(eq(studentEntity))).thenReturn(expected);

        //when
        ResponseEntity<CommonResponseDto> actual = studentResource.postStudent(studentDto);

        //then
        verify(studentService, times(1)).save(eq(studentEntity));
        verify(studentMapper, times(1)).toEntity(studentDto);
    }

    @Test
    public void givenStudent_whenFindById_thenStudentFoundSuccessfully(){
        //given
        StudentEntity expected = TestData.getStudentEntity();
        Long id = expected.getId();
        StudentDto studentDto = TestData.getStudentDto();
        when(studentService.findById(eq(id))).thenReturn(expected);
        when(studentMapper.toDto(expected)).thenReturn(studentDto);

        //when
        ResponseEntity<StudentDto> actual = studentResource.getStudentById(id);

        //then
        verify(studentService, times(1)).findById(eq(id));
        verify(studentMapper, times(1)).toDto(expected);
    }

    @Test
    public void givenStudent_whenFindById_thenExceptionThrows(){
        //given
        Long failedId = 2L;
        when(studentService.findById(2L))
                .thenThrow(new ClassBookException(String.format("Student with id %d was not found", failedId)));

        //when and then
        assertThrows(
                String.format("Student with id %d was not found", failedId),
                ClassBookException.class,
                () -> studentResource.getStudentById(failedId)
        );
        verify(studentService, times(1)).findById(eq(failedId));
    }

    @Test
    public void givenStudentList_whenFindAll_thenFoundStudentListSuccessfully(){
        //given
        StudentEntity student = TestData.getStudentEntity();
        List<StudentEntity> expected = List.of(student);
        PageRequest pageRequest = PageRequest.of(1, 10);
        when(studentService.findAll(eq(pageRequest))).thenReturn(new PageImpl<>(expected));

        //when
        ResponseEntity<PageViewDto<StudentDto>> studentResponse = studentResource.getStudentList(pageRequest);

        //then
        verify(studentService, times(1)).findAll(eq(pageRequest));
    }

    @Test
    public void givenStudent_whenUpdate_thenStudentUpdatedSuccessfully(){
        //given
        StudentEntity studentEntity = TestData.getStudentEntity();
        Long id = studentEntity.getId();
        StudentEntity expected = TestData.getStudentEntity();
        expected.setLastName("Some text");
        StudentDto studentDto = TestData.getStudentDto();
        when(studentService.update(eq(id), eq(studentEntity))).thenReturn(expected);
        when(studentMapper.toEntity(studentDto)).thenReturn(studentEntity);

        //when
        ResponseEntity<CommonResponseDto> studentResponse = studentResource.updateStudent(id, studentDto);

        //then
        verify(studentService, times(1)).update(eq(id), eq(studentEntity));
        verify(studentMapper, times(1)).toEntity(eq(studentDto));
    }

    @Test
    public void givenStudent_whenDelete_thenStudentDeletedSuccessfully(){
        //given
        StudentEntity student = TestData.getStudentEntity();
        Long id = student.getId();
        StudentEntity expected = TestData.getStudentEntity();
        expected.setDeleted(true);
        doNothing().when(studentService).deleteById(eq(id));

        //when
        ResponseEntity<CommonResponseDto> studentEntity = studentResource.deleteStudent(id);

        //then
        verify(studentService, times(1)).deleteById(eq(id));
    }
}

package com.eschool.classbook.student;

import com.eschool.classbook.TestData;
import com.eschool.classbook.credential.CredentialEntity;
import com.eschool.classbook.exception.ClassBookException;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StudentServiceImplUnitTest {
    private final StudentRepository studentRepository = mock(StudentRepository.class);
    private final StudentService studentService = new StudentServiceImpl(studentRepository);

    @Test
    public void givenStudent_wnenSave_thenStudentSavedSuccessfully(){
        //given
        StudentEntity studentEntity = TestData.getStudentEntity();
        studentEntity.setId(null);
        StudentEntity expected = TestData.getStudentEntity();
        when(studentRepository.save(eq(studentEntity))).thenReturn(expected);

        //when
        StudentEntity actual = studentService.save(studentEntity);

        //then
        verify(studentRepository, times(1)).save(eq(studentEntity));
    }

    @Test
    public void givenStudent_whenFindById_thenStudentFoundSuccessfully(){
        //given
        StudentEntity expected = TestData.getStudentEntity();
        Long id = expected.getId();
        when(studentRepository.findById(eq(id))).thenReturn(Optional.of(expected));

        //when
        StudentEntity actual = studentService.findById(id);

        //then
        verify(studentRepository, times(1)).findById(eq(id));
    }

    @Test
    public void givenStudent_whenFindById_thenExceptionThrows(){
        //given
        StudentEntity expected = TestData.getStudentEntity();
        Long id = expected.getId();
        when(studentRepository.findById(eq(id))).thenReturn(Optional.of(expected));
        Long failedId = 2L;

        //when and then
        assertThrows(
                String.format("Student with id %d was not found", failedId),
                ClassBookException.class,
                () -> studentService.findById(failedId)
        );
        verify(studentRepository, times(1)).findById(eq(failedId));
    }

    @Test
    public void givenStudentList_whenFindAll_thenFoundStudentListSuccessfully(){
        //given
        StudentEntity student = TestData.getStudentEntity();
        List<StudentEntity> expected = List.of(student);
        when(studentRepository.findAll(eq(Pageable.unpaged()))).thenReturn(new PageImpl<>(expected));

        //when
        Page<StudentEntity> actual = studentService.findAll(Pageable.unpaged());

        //then
        verify(studentRepository, times(1)).findAll(eq(Pageable.unpaged()));
    }

    @Test
    public void givenStudent_whenUpdate_thenStudentUpdatedSuccessfully(){
        //given
        StudentEntity student = TestData.getStudentEntity();
        Long id = student.getId();
        StudentEntity expected = TestData.getStudentEntity();
        expected.setLastName("Some text");
        when(studentRepository.findById(eq(id))).thenReturn(Optional.of(student));
        when(studentRepository.save(eq(student))).thenReturn(expected);

        //when
        StudentEntity actual = studentService.update(id, student);

        //then
        verify(studentRepository, times(1)).findById(eq(id));
        verify(studentRepository, times(1)).save(eq(student));
    }

    @Test
    public void givenStudent_whenDelete_thenStudentDeletedSuccessfully(){
        //given
        StudentEntity studentEntity = TestData.getStudentEntity();
        Long id = studentEntity.getId();
        CredentialEntity credentialEntity = TestData.getCredentialEntity();
        studentEntity.setCredential(credentialEntity);
        StudentEntity expected = TestData.getStudentEntity();
        expected.setDeleted(true);
        when(studentRepository.findById(eq(id))).thenReturn(Optional.of(studentEntity));
        when(studentRepository.save(eq(studentEntity))).thenReturn(expected);

        //when
        studentService.deleteById(id);

        //then
        verify(studentRepository, times(1)).findById(eq(id));
        verify(studentRepository, times(1)).save(eq(studentEntity));
    }
}

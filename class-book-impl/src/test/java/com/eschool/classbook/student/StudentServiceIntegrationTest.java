package com.eschool.classbook.student;

import com.eschool.classbook.BaseIntegrationTest;
import com.eschool.classbook.TestData;
import com.eschool.classbook.credential.CredentialEntity;
import com.eschool.classbook.credential.CredentialRepository;
import com.eschool.classbook.exception.ClassBookException;
import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.group.GroupRepository;
import com.eschool.classbook.subject.SubjectEntity;
import com.eschool.classbook.subject.SubjectRepository;
import com.eschool.classbook.teacher.TeacherEntity;
import com.eschool.classbook.teacher.TeacherRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;

import java.util.HashSet;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@Sql(
        scripts = {"classpath:sql/data.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class StudentServiceIntegrationTest extends BaseIntegrationTest {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private CredentialRepository credentialRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @After
    public void clean(){
        studentRepository.deleteAll();
        groupRepository.deleteAll();
        subjectRepository.deleteAll();
        teacherRepository.deleteAll();
        //needs to be the last
        credentialRepository.deleteAll();
    }

    @Test
    public void givenStudent_whenSaveStudent_thenSaveSuccessfully(){
        //given
        StudentEntity expected = TestData.getStudent();
        CredentialEntity credential = TestData.getCredential();
        expected.setCredential(credential);
        GroupEntity groupEntity = groupRepository.findById(1L).get();
        expected.setGroup(groupEntity);
        SubjectEntity subjectEntity = subjectRepository.findById(1L).get();
        expected.addSubject(subjectEntity);
        TeacherEntity teacherEntity = teacherRepository.findById(1L).get();
        expected.addTeacher(teacherEntity);

        //when
        StudentEntity actual = studentService.save(expected);

        //then
        assertNotNull(actual);
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.isDeleted(), actual.isDeleted());
        assertEquals(expected.getCredential(), actual.getCredential());
        assertEquals(expected.getGroup(), actual.getGroup());
        assertFalse(actual.getTeachers().isEmpty());
        assertEquals(new HashSet<>(expected.getTeachers()), actual.getTeachers());
        assertFalse(actual.getSubjects().isEmpty());
        assertEquals(new HashSet<>(expected.getSubjects()), actual.getSubjects());
    }

    @Test
    public void givenStudent_whenFindById_thenStudentFoundSuccessfully(){
        //when
        StudentEntity actual = studentService.findById(1L);

        //then
        assertNotNull(actual);
        assertEquals(Long.valueOf(1), actual.getId());
        assertEquals("Steven", actual.getFirstName());
        assertEquals("Venson", actual.getLastName());
        assertFalse(actual.isDeleted());

        CredentialEntity credential = actual.getCredential();
        assertNotNull(credential);
        assertEquals(Long.valueOf(1L), credential.getId());
        assertEquals("steven_venson", credential.getUsername());
        assertEquals("uwjwwwefwko", credential.getPassword());
        assertFalse(credential.isDeleted());

        GroupEntity group = actual.getGroup();
        assertNotNull(group);
        assertEquals(Long.valueOf(1L), group.getId());
        assertEquals("2A", group.getGroupTitle());

        assertFalse(actual.getTeachers().isEmpty());
        assertFalse(actual.getSubjects().isEmpty());
    }

    @Test
    public void givenStudent_whenFindById_thenExceptionThrows(){
        //given
        Long failedId = 10L;

        //when and then
        assertThrows(
                String.format("Student with id %d was not found", failedId),
                ClassBookException.class,
                () -> studentService.findById(failedId)
        );
    }

    //This test needs to be run first cause test order random execution
    @Order(1)
    @Test
    public void givenStudentList_whenFindAll_thenFoundStudentListSuccessfully(){
        //when
        Page<StudentEntity> actual = studentService.findAll(Pageable.unpaged());

        //then
        assertEquals(3,actual.getTotalElements());
        assertEquals(1,actual.getTotalPages());
        assertTrue(actual.stream().allMatch(Objects::nonNull));
    }

    @Test
    public void givenStudent_whenUpdate_thenStudentUpdatedSuccessfully(){
        //given
        String firstName = "Robert";
        Long id = 1L;
        StudentEntity expected = studentService.findById(id);
        expected.setFirstName(firstName);

        //when
        StudentEntity actual = studentService.update(id, expected);

        //then
        assertEquals(firstName, actual.getFirstName());
    }

    @Test
    public void givenStudent_whenDelete_thenStudentDeletedSuccessfully(){
        //given
        Long id = 1L;
        studentService.deleteById(id);

        //when
        studentService.deleteById(id);

        //then
        StudentEntity deletedStudent = studentService.findById(id);
        assertTrue(deletedStudent.isDeleted());
    }
}

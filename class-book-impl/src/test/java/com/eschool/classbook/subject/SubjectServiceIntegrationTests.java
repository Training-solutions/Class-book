package com.eschool.classbook.subject;

import com.eschool.classbook.BaseIntegrationTest;
import com.eschool.classbook.TestData;
import com.eschool.classbook.credential.CredentialRepository;
import com.eschool.classbook.exception.ClassBookException;
import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.group.GroupRepository;
import com.eschool.classbook.student.StudentRepository;
import com.eschool.classbook.teacher.TeacherRepository;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.Assert.*;

@Sql(
        scripts = {"classpath:sql/data.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)

public class SubjectServiceIntegrationTests extends BaseIntegrationTest {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CredentialRepository credentialRepository;

    @After
    public void clean() {
        groupRepository.deleteAll();
        studentRepository.deleteAll();
        subjectRepository.deleteAll();
        teacherRepository.deleteAll();
        credentialRepository.deleteAll();
    }

    @Test
    public void givenSubject_whenSave_thenReturnSuccessfulResult() {
        //given
        SubjectEntity expected = TestData.getSubject();

        //when
        SubjectEntity actual = subjectService.save(expected);

        //then
        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getSubjectTitle(), actual.getSubjectTitle());

    }

    @Test
    public void givenSubject_whenFindById_thenReturnSuccessfulResult(){
        //when
        SubjectEntity actual = subjectService.findById(1L);

        //then
        assertNotNull(actual);
        assertEquals(Long.valueOf(1), actual.getId());
        assertEquals("MATH", actual.getSubjectTitle());
        assertFalse(actual.isDeleted());

    }

    @Test
    public void givenSubject_whenFindById_thenExceptionThrows(){
        //given
        Long failedId = 10L;

        //when and then
        assertThrows(String.format("Subject with id %d was not found", failedId),
                ClassBookException.class,
                () -> subjectService.findById(failedId));
    }

    @Test
    public void givenSubject_whenDeleteById_thenDeletedSuccessfully(){
        //given
        Long id = 1L;

        //when
        subjectService.deleteById(id);

        //then
        SubjectEntity subjectDeleted = subjectService.findById(id);
        assertTrue(subjectDeleted.isDeleted());
    }

}

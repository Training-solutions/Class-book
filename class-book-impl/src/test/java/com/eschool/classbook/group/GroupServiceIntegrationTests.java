package com.eschool.classbook.group;

import com.eschool.classbook.BaseIntegrationTest;
import com.eschool.classbook.TestData;
import com.eschool.classbook.credential.CredentialRepository;
import com.eschool.classbook.student.StudentRepository;
import com.eschool.classbook.subject.SubjectRepository;
import com.eschool.classbook.teacher.TeacherRepository;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Objects;

import static org.junit.Assert.*;

@Sql(
        scripts = {"classpath:sql/data.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)

public class GroupServiceIntegrationTests extends BaseIntegrationTest {

    @Autowired
    private GroupService groupService;

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
    public void givenGroup_whenSaveGroup_thenSaveSuccessfully() {
        //given
        GroupEntity expexted = TestData.getGroup();

        //when
        GroupEntity actual = groupService.save(expexted);

        //then
        assertNotNull(actual);
        assertEquals(expexted.getGroupTitle(), actual.getGroupTitle());
        assertEquals(expexted.getId(), actual.getId());
        assertEquals(expexted.isDeleted(), actual.isDeleted());
        assertTrue(expexted.getStudents().isEmpty());
        assertTrue(expexted.getTeachers().isEmpty());
        assertTrue(expexted.getSubjects().isEmpty());
    }

    @Test
    public void givenGroup_whenFindById_thenReturnSuccessfulResult() {
        //when
        GroupEntity actual = groupService.findById(1L);

        //then
        assertNotNull(actual);
        assertEquals(Long.valueOf(1), actual.getId());
        assertEquals("2A", actual.getGroupTitle());
        assertFalse(actual.isDeleted());
        assertEquals(Long.valueOf(1), actual.getStudents().get(0).getId());

    }

    @Test
    public void givenGroup_whenFindById_thenExceptionThrows() {
        //given
        Long failedId = 123L;

        //when and then
        assertThrows(String.format("Group with id %d wasn't found",
                failedId), ClassCastException.class,
                () -> groupService.findById(failedId));
    }

    @Test
    public void givenGroup_whenDeleteById_thenDeletedSuccessfully(){
        //given
        Long id = 1L;
        GroupEntity groupEntity = groupService.findById(id);

        //when
        groupService.deleteById(id);

        //then
        assertTrue(groupEntity.isDeleted());

    }

    @Test
    public void givenGroupList_whenFindAll_thenFoundGroupListSuccessfully(){
        //when
        Page<GroupEntity> actualGroups = groupService.findAll(PageRequest.of(1, 3));

        //then
        assertEquals(1, actualGroups.getTotalPages());
        assertEquals(3, actualGroups.getTotalElements());
        assertTrue(actualGroups.stream().allMatch(Objects::nonNull));

    }

    @Test
    public void givenGroup_whenUpdate_thenUpdatedSuccessfully(){
        //given
        String title = "Some title";
        GroupEntity expected = groupService.findById(1L);
        expected.setGroupTitle(title);

        //when
        groupService.update(1L, expected);

        //then
        assertEquals(expected.getGroupTitle(), title);

    }
}

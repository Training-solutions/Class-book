package com.eschool.classbook.group;

import com.eschool.classbook.BaseEntity;
import com.eschool.classbook.BaseIntegrationTest;
import com.eschool.classbook.TestData;
import com.eschool.classbook.exception.ClassBookException;
import com.eschool.classbook.student.StudentEntity;
import com.eschool.classbook.subject.SubjectEntity;
import com.eschool.classbook.teacher.TeacherEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.HashSet;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class GroupServiceIntegrationTests extends BaseIntegrationTest {
    @Autowired
    private GroupService groupService;

    @Test
    public void givenGroup_whenSaveGroup_thenSaveSuccessfully() {
        //given
        GroupEntity expected = TestData.getGroupEntity();

        //when
        GroupEntity actual = groupService.save(expected);

        //then
        assertNotNull(actual);
        assertEquals(expected.getGroupTitle(), actual.getGroupTitle());
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.isDeleted(), actual.isDeleted());
        assertTrue(expected.getStudents().isEmpty());
        assertTrue(expected.getTeachers().isEmpty());
        assertTrue(expected.getSubjects().isEmpty());
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
        assertEquals(Long.valueOf(1),
            actual.getStudents().stream().findFirst().get().getId());

    }

    @Test
    public void givenGroup_whenFindById_thenExceptionThrows() {
        //given
        Long failedId = 123L;

        //when and then
        assertThrows(
                String.format("Group with id %d wasn't found", failedId),
                ClassBookException.class,
                () -> groupService.findById(failedId));
    }

    @Test
    public void givenGroup_whenDeleteById_thenDeletedSuccessfully(){
        //given
        Long id = 1L;

        //when
        groupService.deleteById(id);

        //then
        GroupEntity groupEntity = groupService.findById(id);
        assertTrue(groupEntity.isDeleted());
        assertTrue(groupEntity.getStudents().stream().allMatch(BaseEntity::isDeleted));
    }

    @Test
    public void givenGroupList_whenFindAll_thenFoundGroupListSuccessfully(){
        //when
        Page<GroupEntity> actualGroups = groupService.findAll(PageRequest.of(0, 4));

        //then
        assertEquals(1, actualGroups.getTotalPages());
        assertEquals(4, actualGroups.getTotalElements());
        assertTrue(actualGroups.stream().allMatch(Objects::nonNull));
    }

    @Test
    public void givenGroup_whenUpdate_thenUpdatedSuccessfully(){
        //given
        String title = "Some title";
        Long id = 1L;
        Long idNewStudent = 2L;
        Long idNewTeacher = 2L;
        Long idNewSubject = 2L;

        GroupEntity expected = TestData.getGroupEntity();
        StudentEntity newStudent = TestData.getStudentEntity();
        newStudent.setId(2L);
        TeacherEntity newTeacher = TestData.getTeacherEntity();
        newTeacher.setId(2L);
        SubjectEntity newSubject = TestData.getSubjectEntity();
        newSubject.setId(2L);
        expected.setGroupTitle(title);
        expected.addStudent(newStudent);
        expected.addTeacher(newTeacher);
        expected.addSubject(newSubject);

        //when
        GroupEntity actual = groupService.update(id, expected);

        //then
        assertEquals(actual.getGroupTitle(), expected.getGroupTitle());

        assertEquals(new HashSet<>(actual.getStudents()), expected.getStudents());
        assertEquals(new HashSet<>(actual.getTeachers()), expected.getTeachers());
        assertEquals(new HashSet<>(actual.getSubjects()), expected.getSubjects());
    }
}

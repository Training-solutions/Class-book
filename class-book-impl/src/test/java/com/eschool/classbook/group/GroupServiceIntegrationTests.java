package com.eschool.classbook.group;

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
        assertEquals(Long.valueOf(1), actual.getStudents().get(0).getId());

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
        Long idStudent = 1L;

        //when
        groupService.deleteById(id);

        //then
        GroupEntity groupEntity = groupService.findById(id);
        StudentEntity studentEntity = studentRepository.getById(idStudent);
        assertTrue(groupEntity.isDeleted());
        assertTrue(studentEntity.isDeleted());

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
        Long idNewSubject = 2l;

        GroupEntity expected = groupService.findById(id);
        StudentEntity newStudent = studentRepository.getById(idNewStudent);
        TeacherEntity newTeacher = teacherRepository.getById(idNewTeacher);
        SubjectEntity newSubject = subjectRepository.getById(idNewSubject);
        expected.setGroupTitle(title);
        expected.addStudent(newStudent);
        expected.addTeacher(newTeacher);
        expected.addSubject(newSubject);

        //when
        groupService.update(id, expected);

        //then
        assertEquals(expected.getGroupTitle(), title);
        assertTrue(expected.getStudents().contains(newStudent));
        assertTrue(expected.getTeachers().contains(newTeacher));
        assertTrue(expected.getSubjects().contains(newSubject));

    }
}

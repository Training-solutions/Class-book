package com.eschool.classbook.teacher;

import com.eschool.classbook.BaseIntegrationTest;
import com.eschool.classbook.TestData;
import com.eschool.classbook.credential.CredentialEntity;
import com.eschool.classbook.exception.ClassBookException;
import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.subject.SubjectEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class TeacherServiceIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void givenTeacher_whenSaveTeacher_thenSaveSuccessfully() {
        //given
        TeacherEntity expected = TestData.getTeacherEntity();
        CredentialEntity credentialEntity = TestData.getCredentialEntity();
        expected.setCredential(credentialEntity);
        SubjectEntity subjectEntity = subjectRepository.findById(1L).get();
        expected.addSubject(subjectEntity);

        //when
        TeacherEntity actual = teacherService.save(expected);

        //then
        assertNotNull(actual);
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.isDeleted(), actual.isDeleted());
        assertEquals(expected.getCredential(), actual.getCredential());
        assertEquals(new HashSet<>(expected.getSubjects()), actual.getSubjects());
    }

    @Test
    public void givenTeacher_whenFindById_thenTeacherFoundSuccessfully(){
        //when
        TeacherEntity actual = teacherService.findById(1L);

        //then
        assertNotNull(actual);
        assertEquals("David", actual.getFirstName());
        assertEquals("Hekston", actual.getLastName());
        assertFalse(actual.isDeleted());

        CredentialEntity credential = actual.getCredential();
        assertNotNull(credential);
        assertEquals(Long.valueOf(4L), credential.getId());
        assertEquals("robert_tasert", credential.getUsername());
        assertEquals("sdgsgs134", credential.getPassword());
        assertFalse(credential.isDeleted());

        assertNotNull(actual.getGroups());
        Set<GroupEntity> groups = actual.getGroups();
        assertFalse(groups.isEmpty());
        groups.forEach(Assert::assertNotNull);
    }

    @Test
    public void givenTeacher_whenFindById_thenExceptionThrows(){
        //given
        Long failedId = 10L;

        //when and then
        assertThrows(
                String.format("Teacher with id %d was not found", failedId),
                ClassBookException.class,
                ()->teacherService.findById(failedId)
        );
    }

    @Test
    public void givenTeacherList_whenFindAll_thenFoundTeacherListSuccessfully(){
        //when
        Page<TeacherEntity> actual = teacherService.findAll(PageRequest.of(1, 3));

        //then
        assertEquals(1, actual.getTotalPages());
        assertEquals(3, actual.getTotalElements());
        assertTrue(actual.stream().allMatch(Objects::nonNull));
    }

    @Test
    public void givenTeacher_whenUpdate_thenTeacherUpdatedSuccessfully() {
        //given
        String firstName = "Some name";
        Long id = 2L;
        Long idGroupAdd = 3L;
        Long idGroupRemove = 2L;
        Long idSubjectAdd = 1L;
        String password = "Some_password";
        
        TeacherEntity expected = teacherService.findById(id);
        GroupEntity groupExpected = groupRepository.getById(idGroupAdd);
        GroupEntity groupRemove = groupRepository.getById(idGroupRemove);
        SubjectEntity subjectExpected = subjectRepository.getById(idSubjectAdd);
        expected.setFirstName(firstName);
        expected.addGroup(groupExpected);
        expected.removeGroup(groupRemove);
        expected.addSubject(subjectExpected);
        expected.getCredential().setPassword(password);

        //when
        TeacherEntity actual = teacherService.update(id, expected);

        //then
        assertTrue(actual.getGroups().contains(groupExpected));
        assertFalse(actual.getGroups().contains(groupRemove));
        assertEquals(actual.getFirstName(), expected.getFirstName());
        assertTrue(actual.getSubjects().contains(subjectExpected));
        assertEquals(actual.getCredential().getPassword(), expected.getCredential().getPassword());
    }

    @Test
    public void givenTeacher_whenDelete_thenTeacherDeletedSuccessfully(){
        //given
        Long id = 1L;

        //when
        teacherService.deleteById(id);

        //then
        TeacherEntity actual = teacherService.findById(id);
        assertTrue(actual.isDeleted());
        assertTrue(actual.getCredential().isDeleted());
    }

}

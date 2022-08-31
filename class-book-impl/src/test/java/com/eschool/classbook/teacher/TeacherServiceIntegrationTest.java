package com.eschool.classbook.teacher;

import com.eschool.classbook.BaseIntegrationTest;
import com.eschool.classbook.TestData;
import com.eschool.classbook.credential.CredentialEntity;
import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.subject.SubjectEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

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

}

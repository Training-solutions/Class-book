package com.eschool.classbook;

import com.eschool.classbook.credential.CredentialEntity;
import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.scorepage.Score;
import com.eschool.classbook.scorepage.ScoreEntity;
import com.eschool.classbook.student.StudentEntity;
import com.eschool.classbook.subject.SubjectEntity;
import com.eschool.classbook.teacher.TeacherEntity;
import com.eschool.openapi.v1.model.CredentialDto;
import com.eschool.openapi.v1.model.StudentDto;
import com.eschool.openapi.v1.model.SubjectDto;

import java.time.LocalDateTime;

public class TestData {
    public static StudentEntity getStudentEntity() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName("David");
        studentEntity.setLastName("Emerston");
        studentEntity.setCreationDate(LocalDateTime.of(2020,8,10,11,10,45));
        studentEntity.setModifyingDate(LocalDateTime.of(2021,7,10,14,12,58));
        studentEntity.setDeleted(false);
        return studentEntity;
    }

    public static StudentDto getStudentDto() {
        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName("David");
        studentDto.setLastName("Emerston");
        return studentDto;
    }

    public static SubjectEntity getSubject() {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubjectTitle("Math");
        subjectEntity.setCreationDate(LocalDateTime.now());
        subjectEntity.setModifyingDate(LocalDateTime.now());
        subjectEntity.setDeleted(false);
        return subjectEntity;
    }

    public static ScoreEntity getScore() {
        ScoreEntity scoreEntity = new ScoreEntity();
        scoreEntity.setScore(Score.ELEVEN);
        scoreEntity.setDeleted(false);
        scoreEntity.setCreationDate(LocalDateTime.now());
        scoreEntity.setModifyingDate(LocalDateTime.now());
        return scoreEntity;
    }

    public static TeacherEntity getTeacher() {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setFirstName("Leo");
        teacherEntity.setLastName("Davidson");
        teacherEntity.setDeleted(false);
        teacherEntity.setCreationDate(LocalDateTime.now());
        teacherEntity.setModifyingDate(LocalDateTime.now());
        return teacherEntity;
    }

    public static GroupEntity getGroup() {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setGroupTitle("1A");
        groupEntity.setCreationDate(LocalDateTime.now());
        groupEntity.setModifyingDate(LocalDateTime.now());
        groupEntity.setDeleted(true);
        return groupEntity;
    }

    public static CredentialEntity getCredential() {
        CredentialEntity credentialEntity = new CredentialEntity();
        credentialEntity.setUsername("david_emerston");
        credentialEntity.setPassword("qwerty");
        credentialEntity.setCreationDate(LocalDateTime.now());
        credentialEntity.setModifyingDate(LocalDateTime.now());
        credentialEntity.setDeleted(true);
        return credentialEntity;
    }

    public static CredentialDto getCredentialDto() {
        CredentialDto credentialDto = new CredentialDto();
        credentialDto.setUsername("david_emerston");
        credentialDto.setPassword("qwerty");
        return credentialDto;
    }
}

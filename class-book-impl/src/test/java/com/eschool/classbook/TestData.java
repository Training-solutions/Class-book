package com.eschool.classbook;

import com.eschool.classbook.credential.CredentialEntity;
import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.scorepage.Score;
import com.eschool.classbook.scorepage.ScoreEntity;
import com.eschool.classbook.student.StudentEntity;
import com.eschool.classbook.subject.SubjectEntity;
import com.eschool.classbook.teacher.TeacherEntity;

import java.time.LocalDateTime;

public class TestData {
    public static StudentEntity getStudent() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(1L);
        studentEntity.setFirstName("David");
        studentEntity.setLastName("Emerston");
        studentEntity.setCreationDate(LocalDateTime.now());
        studentEntity.setModifyingDate(LocalDateTime.now());
        studentEntity.setDeleted(false);
        return studentEntity;
    }

    public static SubjectEntity getSubject() {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setId(1L);
        subjectEntity.setSubjectTitle("Math");
        subjectEntity.setCreationDate(LocalDateTime.now());
        subjectEntity.setModifyingDate(LocalDateTime.now());
        subjectEntity.setDeleted(false);
        return subjectEntity;
    }

    public static ScoreEntity getScore() {
        ScoreEntity scoreEntity = new ScoreEntity();
        scoreEntity.setId(1L);
        scoreEntity.setScore(Score.ELEVEN);
        scoreEntity.setDeleted(false);
        scoreEntity.setCreationDate(LocalDateTime.now());
        scoreEntity.setModifyingDate(LocalDateTime.now());
        return scoreEntity;
    }

    public static TeacherEntity getTeacher() {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(1L);
        teacherEntity.setFirstName("Leo");
        teacherEntity.setLastName("Davidson");
        teacherEntity.setDeleted(false);
        teacherEntity.setCreationDate(LocalDateTime.now());
        teacherEntity.setModifyingDate(LocalDateTime.now());
        return teacherEntity;
    }

    public static GroupEntity getGroup() {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setId(1L);
        groupEntity.setGroupTitle("1A");
        groupEntity.setCreationDate(LocalDateTime.now());
        groupEntity.setModifyingDate(LocalDateTime.now());
        groupEntity.setDeleted(true);
        return groupEntity;
    }

    public static CredentialEntity getCredential() {
        CredentialEntity credentialEntity = new CredentialEntity();
        credentialEntity.setId(1L);
        credentialEntity.setUsername("david_emerston");
        credentialEntity.setPassword("qwerty");
        credentialEntity.setCreationDate(LocalDateTime.now());
        credentialEntity.setModifyingDate(LocalDateTime.now());
        credentialEntity.setDeleted(true);
        return credentialEntity;
    }
}

package com.eschool.classbook;

import com.eschool.classbook.credential.CredentialEntity;
import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.mark.Mark;
import com.eschool.classbook.mark.MarkEntity;
import com.eschool.classbook.student.StudentEntity;
import com.eschool.classbook.subject.SubjectEntity;
import com.eschool.classbook.teacher.TeacherEntity;
import com.eschool.openapi.v1.model.CredentialDto;
import com.eschool.openapi.v1.model.GroupDto;
import com.eschool.openapi.v1.model.StudentDto;
import com.eschool.openapi.v1.model.SubjectDto;
import com.eschool.openapi.v1.model.TeacherDto;

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

    public static SubjectEntity getSubjectEntity() {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubjectTitle("Math");
        subjectEntity.setCreationDate(LocalDateTime.now());
        subjectEntity.setModifyingDate(LocalDateTime.now());
        subjectEntity.setDeleted(false);
        return subjectEntity;
    }

    public static SubjectDto getSubjectDto(){
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setSubjectTitle("Math");
        return subjectDto;
    }

    public static MarkEntity getScoreEntity() {
        MarkEntity markEntity = new MarkEntity();
        markEntity.setMark(Mark.ELEVEN);
        markEntity.setDeleted(false);
        markEntity.setCreationDate(LocalDateTime.now());
        markEntity.setModifyingDate(LocalDateTime.now());
        return markEntity;
    }

    public static TeacherEntity getTeacherEntity() {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setFirstName("Leo");
        teacherEntity.setLastName("Davidson");
        teacherEntity.setDeleted(false);
        teacherEntity.setCreationDate(LocalDateTime.now());
        teacherEntity.setModifyingDate(LocalDateTime.now());
        return teacherEntity;
    }

    public static TeacherDto getTeacherDto() {
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setFirstName("Leo");
        teacherDto.setLastName("Davidson");
        return teacherDto;
    }

    public static GroupEntity getGroupEntity() {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setGroupTitle("1A");
        groupEntity.setCreationDate(LocalDateTime.now());
        groupEntity.setModifyingDate(LocalDateTime.now());
        groupEntity.setDeleted(true);
        return groupEntity;
    }

    public static GroupDto getGroupDto(){
        GroupDto groupDto = new GroupDto();
        groupDto.setGroupTitle("1A");
        return groupDto;
    }

    public static CredentialEntity getCredentialEntity() {
        CredentialEntity credentialEntity = new CredentialEntity();
        credentialEntity.setUsername("david_emerston");
        credentialEntity.setPassword("qwerty");
        credentialEntity.setCreationDate(LocalDateTime.now());
        credentialEntity.setModifyingDate(LocalDateTime.now());
        credentialEntity.setDeleted(false);
        return credentialEntity;
    }

    public static CredentialDto getCredentialDto() {
        CredentialDto credentialDto = new CredentialDto();
        credentialDto.setUsername("david_emerston");
        credentialDto.setPassword("qwerty");
        return credentialDto;
    }
}

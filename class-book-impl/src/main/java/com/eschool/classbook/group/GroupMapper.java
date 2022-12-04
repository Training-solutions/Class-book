package com.eschool.classbook.group;

import com.eschool.classbook.BaseMapper;
import com.eschool.classbook.student.StudentEntity;
import com.eschool.classbook.subject.SubjectEntity;
import com.eschool.classbook.teacher.TeacherEntity;
import com.eschool.openapi.v1.model.GroupDto;
import com.eschool.openapi.v1.model.StudentDto;
import com.eschool.openapi.v1.model.SubjectDto;
import com.eschool.openapi.v1.model.TeacherDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface GroupMapper extends BaseMapper {
    GroupDto toDto(GroupEntity source);

    GroupEntity toEntity(GroupDto source);

    @Mapping(target = "teachers", ignore = true)
    @Mapping(target = "subjects", ignore = true)
    @Mapping(target = "group", ignore = true)
    @Mapping(target = "credential", ignore = true)
    StudentDto mapStudentDto(StudentEntity source);

    @Mapping(target = "teachers", ignore = true)
    @Mapping(target = "subjects", ignore = true)
    @Mapping(target = "group", ignore = true)
    @Mapping(target = "credential", ignore = true)
    StudentEntity mapStudentEntity(StudentDto studentDto);

    @Mapping(target = "groups", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "subjects", ignore = true)
    @Mapping(target = "credential", ignore = true)
    TeacherDto mapTeacherDto(TeacherEntity source);

    @Mapping(target = "groups", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "subjects", ignore = true)
    @Mapping(target = "credential", ignore = true)
    TeacherEntity mapTeacherEntity(TeacherDto source);

    @Mapping(target = "groups", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    SubjectDto mapSubjectDto(SubjectEntity subjectEntity);

    @Mapping(target = "groups", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    SubjectEntity mapSubjectEntity(SubjectDto source);
}

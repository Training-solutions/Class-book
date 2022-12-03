package com.eschool.classbook.teacher;

import com.eschool.classbook.BaseMapper;
import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.student.StudentEntity;
import com.eschool.classbook.subject.SubjectEntity;
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
public interface TeacherMapper extends BaseMapper {
    TeacherDto toDto(TeacherEntity source);

    TeacherEntity toEntity(TeacherDto source);

    @Mapping(target = "students", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    @Mapping(target = "groups", ignore = true)
    SubjectDto mapSubjectDto(SubjectEntity source);

    @Mapping(target = "students", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    @Mapping(target = "groups", ignore = true)
    SubjectEntity mapSubjectEntity(SubjectDto source);

    @Mapping(target = "group", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    @Mapping(target = "subjects", ignore = true)
    @Mapping(target = "credential", ignore = true)
    StudentDto mapStudentDto(StudentEntity source);

    @Mapping(target = "group", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    @Mapping(target = "subjects", ignore = true)
    @Mapping(target = "credential", ignore = true)
    StudentEntity mapStudentEntity(StudentDto source);

    @Mapping(target = "subjects", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    GroupDto mapGroupDto(GroupEntity source);

    @Mapping(target = "subjects", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    GroupEntity mapGroupEntity(GroupDto source);

}

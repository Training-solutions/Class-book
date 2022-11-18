package com.eschool.classbook.subject;

import com.eschool.classbook.BaseMapper;
import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.student.StudentEntity;
import com.eschool.openapi.v1.model.GroupDto;
import com.eschool.openapi.v1.model.StudentDto;
import com.eschool.openapi.v1.model.SubjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface SubjectMapper extends BaseMapper {

    @Mapping(target = "teachers.students", ignore = true)
    @Mapping(target = "teachers.groups", ignore = true)
    @Mapping(target = "teachers.subjects", ignore = true)
    SubjectDto toDto(SubjectEntity source);

    @Mapping(target = "teachers.students", ignore = true)
    @Mapping(target = "teachers.groups", ignore = true)
    @Mapping(target = "teachers.subjects", ignore = true)
    SubjectEntity toEntity(SubjectDto source);

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

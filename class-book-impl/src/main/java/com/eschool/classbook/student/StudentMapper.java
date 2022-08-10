package com.eschool.classbook.student;

import com.eschool.classbook.BaseMapper;
import com.eschool.openapi.v1.model.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface StudentMapper extends BaseMapper {
    StudentDto toDto (StudentEntity source);
    StudentEntity toEntity(StudentDto source);
}

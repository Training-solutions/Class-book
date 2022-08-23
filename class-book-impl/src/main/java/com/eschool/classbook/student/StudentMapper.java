package com.eschool.classbook.student;

import com.eschool.classbook.BaseMapper;
import com.eschool.openapi.v1.model.StudentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper extends BaseMapper {
    StudentDto toDTO (StudentEntity studentEntity);
    StudentEntity toEntity (StudentDto studentDto);
}

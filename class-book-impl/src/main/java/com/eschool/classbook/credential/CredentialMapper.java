package com.eschool.classbook.credential;

import com.eschool.classbook.BaseMapper;
import com.eschool.openapi.v1.model.CredentialDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface CredentialMapper extends BaseMapper {
    CredentialDto toDto(CredentialEntity source);
    CredentialEntity toEntity(CredentialDto source);
}

package com.eschool.classbook.report;

import com.eschool.classbook.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
    componentModel = "spring",
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface ReportMapper extends BaseMapper {
}

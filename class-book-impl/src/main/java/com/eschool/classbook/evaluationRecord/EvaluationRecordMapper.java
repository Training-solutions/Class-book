package com.eschool.classbook.evaluationRecord;

import com.eschool.classbook.BaseMapper;
import com.eschool.classbook.group.GroupEntity;
import com.eschool.openapi.v1.model.EvaluationRecordDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface EvaluationRecordMapper extends BaseMapper {
    EvaluationRecordDto toDto(GroupEntity groupEntity);
}

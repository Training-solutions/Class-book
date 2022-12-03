package com.eschool.classbook;

import com.eschool.classbook.mark.Mark;
import com.eschool.openapi.v1.model.MarkDto;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface BaseMapper {

    default OffsetDateTime toOffsetDateTime(LocalDateTime localDateTime){
        return ZonedDateTime.of(localDateTime, ZoneId.systemDefault()).toOffsetDateTime();
    }

    default LocalDateTime toLocalDateTime(OffsetDateTime offsetDateTime) {
        return offsetDateTime.toLocalDateTime();
    }

    default Mark toMarkEntity(MarkDto.MarkEnum value) {
        return Mark.valueOf(value.name());
    }
    default MarkDto.MarkEnum toMarkDto(Mark mark){
        int value = mark.getValue();
        return MarkDto.MarkEnum.fromValue(value);
    }
}

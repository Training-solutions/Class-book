package com.eschool.classbook;

import com.eschool.classbook.score.Score;
import com.eschool.openapi.v1.model.ScoreDto;

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

    default Score toScoreEntity(ScoreDto.ScoreEnum value) {
        return Score.valueOf(value.name());
    }

    default ScoreDto.ScoreEnum toScoreDto(Score score){
        int value = score.getValue();
        return ScoreDto.ScoreEnum.fromValue(value);
    }
}

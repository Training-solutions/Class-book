package com.eschool.classbook.score;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScoreService {
    Page<ScoreEntity> findAll(Pageable pageable);
    ScoreEntity findById(Long id);
    void deleteById(Long id);
    ScoreEntity save(ScoreEntity scoreEntity);
    ScoreEntity update(Long id, ScoreEntity scoreEntity);
}

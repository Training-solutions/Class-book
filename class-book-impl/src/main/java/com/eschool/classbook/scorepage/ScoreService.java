package com.eschool.classbook.scorepage;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ScoreService {
    Page<ScoreEntity> findAll(Pageable pageable);
    Optional<ScoreEntity> findById(Long id);
    void deleteById(Long id);
    ScoreEntity save(ScoreEntity scoreEntity);
    ScoreEntity update(Long id, ScoreEntity scoreEntity);
}

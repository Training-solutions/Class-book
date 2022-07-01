package com.eschool.classbook.scorepage;

import com.eschool.classbook.group.GroupEntity;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface ScorepageService {
    Page<ScoreEntity> findAll(Pageable pageable);
    Optional<ScoreEntity> findById(Long id);
    void deleteById(Long id);
    ScoreEntity save(ScoreEntity scoreEntity);
    ScoreEntity update(Long id, ScoreEntity scoreEntity);
}

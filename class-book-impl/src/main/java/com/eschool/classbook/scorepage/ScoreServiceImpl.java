package com.eschool.classbook.scorepage;

import com.eschool.classbook.exception.ClassBookException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository;

    public ScoreServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public Page<ScoreEntity> findAll(Pageable pageable) {
        return scoreRepository.findAll(pageable);
    }

    @Override
    public Optional<ScoreEntity> findById(Long id) {
        return Optional.ofNullable(Optional.of(scoreRepository.getById(id))
                .orElseThrow(() -> new ClassBookException(String.format("Score with id %d wasn't found", id))));
    }

    @Override
    public void deleteById(Long id) {
        ScoreEntity score = Optional.of(scoreRepository.getById(id))
                .orElseThrow(() -> new ClassBookException(String.format("Score with id %d wasn't found", id)));
        score.setModifyingDate(LocalDateTime.now());
        score.setDeleted(true);
        scoreRepository.save(score);
    }

    @Override
    public ScoreEntity save(ScoreEntity scoreEntity) {
        return scoreRepository.save(scoreEntity);
    }

    @Override
    public ScoreEntity update(Long id, ScoreEntity scoreEntity) {
        Optional.of(scoreRepository.getById(id))
                .orElseThrow(() -> new ClassBookException(String.format("Score with id %d wasn't found", id)));
        scoreEntity.setModifyingDate(LocalDateTime.now());
        return scoreRepository.save(scoreEntity);
    }
}

package com.eschool.classbook.scorepage;

import com.eschool.classbook.exception.ClassBookException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
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
    public ScoreEntity findById(Long id) {
        return scoreRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Score with id %d was not found", id)));
    }

    @Override
    public void deleteById(Long id) {
        ScoreEntity score = scoreRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Score with id %d wasn't found", id)));
        score.setDeleted(true);
        scoreRepository.save(score);
    }

    @Override
    public ScoreEntity save(ScoreEntity scoreEntity) {
        return scoreRepository.save(scoreEntity);
    }

    @Override
    public ScoreEntity update(Long id, ScoreEntity scoreEntity) {
        scoreRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Score with id %d wasn't found", id)));
        return scoreRepository.save(scoreEntity);
    }
}

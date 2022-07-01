package com.eschool.classbook.scorepage;

import com.eschool.classbook.group.GroupEntity;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ScorepageServiceImpl implements ScorepageService{

    private final ScorepageRepository scorepageRepository;

    public ScorepageServiceImpl(ScorepageRepository scorepageRepository) {
        this.scorepageRepository = scorepageRepository;
    }

    @Override
    public Page<ScoreEntity> findAll(Pageable pageable) {
        return (Page<ScoreEntity>) scorepageRepository.findAll();
    }

    @Override
    public Optional<ScoreEntity> findById(Long id) {
        return Optional.ofNullable(Optional.of(scorepageRepository.getById(id))
                .orElseThrow(() -> new NoSuchElementException(String.format("Scorepage with id %d wasn't found", id))));
    }

    @Override
    public void deleteById(Long id) {
        ScoreEntity scorepage = Optional.of(scorepageRepository.getById(id))
                .orElseThrow(() -> new NoSuchElementException(String.format("Scorepage with id %d wasn't found", id)));
        scorepage.setModifyingDate(LocalDateTime.now());
        scorepage.setDeleted(true);
        scorepageRepository.save(scorepage);
    }

    @Override
    public ScoreEntity save(ScoreEntity scoreEntity) {
        return scorepageRepository.save(scoreEntity);
    }

    @Override
    public ScoreEntity update(Long id, ScoreEntity scoreEntity) {
        Optional.of(scorepageRepository.getById(id))
                .orElseThrow(() -> new NoSuchElementException(String.format("Scorepage with id %d wasn't found", id)));
        scoreEntity.setModifyingDate(LocalDateTime.now());
        return scorepageRepository.save(scoreEntity);
    }
}

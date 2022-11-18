package com.eschool.classbook.mark;

import com.eschool.classbook.exception.ClassBookException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MarkServiceImpl implements MarkService {

    private final MarkRepository markRepository;

    public MarkServiceImpl(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    @Override
    public Page<MarkEntity> findAll(Pageable pageable) {
        return markRepository.findAll(pageable);
    }

    @Override
    public MarkEntity findById(Long id) {
        return markRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Score with id %d was not found", id)));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        MarkEntity score = markRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Score with id %d wasn't found", id)));
        score.setDeleted(true);
        markRepository.save(score);
    }

    @Override
    public MarkEntity save(MarkEntity markEntity) {
        return markRepository.save(markEntity);
    }

    @Override
    @Transactional
    public MarkEntity update(Long id, MarkEntity markEntity) {
        markRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Score with id %d wasn't found", id)));
        return markRepository.save(markEntity);
    }
}

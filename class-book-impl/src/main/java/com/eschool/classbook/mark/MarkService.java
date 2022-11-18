package com.eschool.classbook.mark;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MarkService {
    Page<MarkEntity> findAll(Pageable pageable);
    MarkEntity findById(Long id);
    void deleteById(Long id);
    MarkEntity save(MarkEntity markEntity);
    MarkEntity update(Long id, MarkEntity markEntity);
}

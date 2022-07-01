package com.eschool.classbook.group;

import com.eschool.classbook.scorepage.ScorepageRepository;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface GroupService {

    Page<GroupEntity> findAll(Pageable pageable);
    Optional<GroupEntity> findById(Long id);
    void deleteById(Long id);
    GroupEntity save(GroupEntity groupEntity);
    GroupEntity update(Long id, GroupEntity groupEntity);
}

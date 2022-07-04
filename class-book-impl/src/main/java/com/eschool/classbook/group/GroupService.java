package com.eschool.classbook.group;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GroupService {

    Page<GroupEntity> findAll(Pageable pageable);
    Optional<GroupEntity> findById(Long id);
    void deleteById(Long id);
    GroupEntity save(GroupEntity groupEntity);
    GroupEntity update(Long id, GroupEntity groupEntity);
}

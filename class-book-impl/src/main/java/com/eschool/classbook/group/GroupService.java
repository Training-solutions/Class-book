package com.eschool.classbook.group;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupService {
    Page<GroupEntity> findAll(Pageable pageable);
    GroupEntity findById(Long id);
    void deleteById(Long id);
    GroupEntity save(GroupEntity groupEntity);
    GroupEntity update(Long id, GroupEntity groupEntity);
}

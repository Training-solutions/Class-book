package com.eschool.classbook.group;

import com.eschool.classbook.exception.ClassBookException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService{

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Page<GroupEntity> findAll(Pageable pageable) {
        return groupRepository.findAll(pageable);
    }

    @Override
    public GroupEntity findById(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Group with id %d wasn't found", id)));
    }

    @Override
    public void deleteById(Long id) {
        GroupEntity group = Optional.of(groupRepository.getById(id))
                .orElseThrow(() -> new ClassBookException(String.format("Group with id %d wasn't found", id)));
        group.setModifyingDate(LocalDateTime.now());
        group.setDeleted(true);
        groupRepository.save(group);

    }

    @Override
    public GroupEntity save(GroupEntity groupEntity) {
        return groupRepository.save(groupEntity);
    }

    @Override
    public GroupEntity update(Long id, GroupEntity groupEntity) {
        groupRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Group with id %d was not found", id)));
        groupEntity.setModifyingDate(LocalDateTime.now());
        return groupRepository.save(groupEntity);
    }
}

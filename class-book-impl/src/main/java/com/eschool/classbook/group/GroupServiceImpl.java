package com.eschool.classbook.group;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService{

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Page<GroupEntity> findAll(Pageable pageable) {
        return (Page<GroupEntity>) groupRepository.findAll();
    }

    @Override
    public Optional<GroupEntity> findById(Long id) {
        return Optional.ofNullable(Optional.of(groupRepository.getById(id))
                .orElseThrow(() -> new NoSuchElementException(String.format("Group with id %d wasn't found", id))));
    }

    @Override
    public void deleteById(Long id) {
        GroupEntity group = Optional.of(groupRepository.getById(id))
                .orElseThrow(() -> new NoSuchElementException(String.format("Group with id %d wasn't found", id)));
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
        Optional.of(groupRepository.getById(id))
                .orElseThrow(() -> new NoSuchElementException(String.format("Group with id %d wasn't found", id)));
        groupEntity.setModifyingDate(LocalDateTime.now());
        return groupRepository.save(groupEntity);
    }
}

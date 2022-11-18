package com.eschool.classbook.group;

import com.eschool.openapi.v1.api.GroupsV1Api;
import com.eschool.openapi.v1.model.CommonResponseDto;
import com.eschool.openapi.v1.model.GroupDto;
import com.eschool.openapi.v1.model.PageViewDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class GroupResource implements GroupsV1Api {
    private final GroupMapper groupMapper;
    private final GroupService groupService;

    @Override
    public ResponseEntity<CommonResponseDto> deleteGroup(Long groupId) {
        groupService.deleteById(groupId);
        CommonResponseDto commonResponseDto = new CommonResponseDto(groupId,
            String.format("Group with id - %d deleted successfully", groupId));
        return ResponseEntity.ok(commonResponseDto);
    }

    @Override
    public ResponseEntity<GroupDto> getGroupById(Long groupId) {
        GroupEntity groupEntity = groupService.findById(groupId);
        GroupDto groupDto = groupMapper.toDto(groupEntity);
        return ResponseEntity.ok(groupDto);
    }

    @Override
    public ResponseEntity<PageViewDto<GroupDto>> getGroupList(Pageable pageable) {
        Page<GroupEntity> groupEntities = groupService.findAll(pageable);
        List<GroupDto> collect = groupEntities.getContent().stream().map(groupMapper::toDto).collect(Collectors.toList());
        PageViewDto<GroupDto> pageViewDto = new PageViewDto<>(collect);
        return ResponseEntity.ok(pageViewDto);
    }

    @Override
    public ResponseEntity<CommonResponseDto> postGroup(GroupDto groupDto) {
        GroupEntity groupEntity = groupMapper.toEntity(groupDto);
        GroupEntity savedGroup = groupService.save(groupEntity);
        Long id = savedGroup.getId();
        CommonResponseDto commonResponseDto = new CommonResponseDto(id,
            String.format("Group with id - %d saved successfully",id));
        return ResponseEntity.ok(commonResponseDto);
    }

    @Override
    public ResponseEntity<CommonResponseDto> updateGroup(Long groupId, GroupDto groupDto) {
        GroupEntity groupEntity = groupMapper.toEntity(groupDto);
        groupService.update(groupId, groupEntity);
        CommonResponseDto commonResponseDto = new CommonResponseDto(groupId,
            String.format("Group with id - %d updated successfully", groupId));
        return ResponseEntity.ok(commonResponseDto);
    }
}

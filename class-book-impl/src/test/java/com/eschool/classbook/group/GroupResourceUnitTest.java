package com.eschool.classbook.group;

import com.eschool.classbook.TestData;
import com.eschool.classbook.exception.ClassBookException;
import com.eschool.openapi.v1.api.GroupsV1Api;
import com.eschool.openapi.v1.model.CommonResponseDto;
import com.eschool.openapi.v1.model.GroupDto;
import static org.junit.Assert.assertThrows;

import com.eschool.openapi.v1.model.PageViewDto;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


public class GroupResourceUnitTest {
    private final GroupService groupService = mock(GroupService.class);
    private final GroupMapper groupMapper = mock(GroupMapper.class);
    private final GroupsV1Api groupResource = new GroupResource(groupMapper, groupService);

    @Test
    public  void givenGroup_whenSave_thenGroupSavedSuccessfully(){
        //given
        GroupEntity groupEntity = TestData.getGroupEntity();
        GroupEntity expected = TestData.getGroupEntity();
        GroupDto groupDto = TestData.getGroupDto();

        when(groupMapper.toEntity(eq(groupDto))).thenReturn(groupEntity);
        when(groupService.save(eq(groupEntity))).thenReturn(expected);

        //when
        ResponseEntity<CommonResponseDto> actual = groupResource.postGroup(groupDto);

        //then
        verify(groupService, times(1)).save(eq(groupEntity));
        verify(groupMapper, times(1)).toEntity(eq(groupDto));
    }

    @Test
    public void givenGroup_whenFindById_thenGroupFoundSuccessfully(){
        //given
        GroupEntity expected = TestData.getGroupEntity();
        Long id = expected.getId();
        GroupDto groupDto = TestData.getGroupDto();

        when(groupService.findById(eq(id))).thenReturn(expected);
        when(groupMapper.toDto(expected)).thenReturn(groupDto);

        //when
        ResponseEntity<GroupDto> actual = groupResource.getGroupById(id);

        //then
        verify(groupService, times(1)).findById(eq(id));
        verify(groupMapper, times(1)).toDto(expected);
    }

    @Test
    public void givenGroup_whenFindById_thenExceptionThrows(){
        //given
        Long failedId = 2L;

        when(groupService.findById(failedId))
                .thenThrow(new ClassBookException(String.format("Group with id %d was not found", failedId)));

        //when and then
        assertThrows(
                String.format("Group with id %d was not found", failedId),
                ClassBookException.class,
                () ->groupResource.getGroupById(failedId)
        );

        verify(groupService, times(1)).findById(eq(failedId));
    }

    @Test
    public void givenGroupList_whenFindAll_thenFoundGroupListSuccessfully(){
        //given
        GroupEntity groupEntity = TestData.getGroupEntity();
        List<GroupEntity> expected = List.of(groupEntity);
        PageRequest pageRequest = PageRequest.of(1,10);
        when(groupService.findAll(eq(pageRequest))).thenReturn(new PageImpl<>(expected));

        //when
        ResponseEntity<PageViewDto<GroupDto>> groupResponse = groupResource.getGroupList(pageRequest);

        //then
        verify(groupService, times(1)).findAll(eq(pageRequest));
        verify(groupMapper, times(1)).toDto(groupEntity);
    }

    @Test
    public void givenGroup_whenUpdate_thenGroupUpdatedSuccessfully(){
        //given
        GroupEntity groupEntity = TestData.getGroupEntity();
        Long id = groupEntity.getId();
        GroupEntity expected = TestData.getGroupEntity();
        expected.setGroupTitle("Some text");
        GroupDto groupDto = TestData.getGroupDto();
        when(groupService.update(eq(id), eq(groupEntity))).thenReturn(expected);
        when(groupMapper.toEntity(groupDto)).thenReturn(groupEntity);

        //when
        ResponseEntity<CommonResponseDto> groupResponse = groupResource.updateGroup(id, groupDto);

        //then
        verify(groupService, times(1)).update(eq(id), eq(groupEntity));
        verify(groupMapper, times(1)).toEntity(groupDto);

    }

    @Test
    public void givenGroup_whenDelete_thenGroupDeletedSuccessfully(){
        //given
        GroupEntity group = TestData.getGroupEntity();
        Long id = group.getId();
        GroupEntity expected = TestData.getGroupEntity();
        expected.setDeleted(true);
        doNothing().when(groupService).deleteById(id);

        //when
        ResponseEntity<CommonResponseDto> groupEntity = groupResource.deleteGroup(id);

        //then
        verify(groupService, times(1)).deleteById(eq(id));

    }
}

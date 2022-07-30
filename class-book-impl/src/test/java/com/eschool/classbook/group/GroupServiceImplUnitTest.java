package com.eschool.classbook.group;

import com.eschool.classbook.TestData;
import com.eschool.classbook.exception.ClassBookException;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.junit.Assert.assertThrows;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class GroupServiceImplUnitTest {
    private GroupRepository groupRepository = mock(GroupRepository.class);

    private final GroupService groupService = new GroupServiceImpl(groupRepository);

    @Test
    public void givenGroup_whenSave_thenReturnSuccessfulResult() {
        //given
        GroupEntity groupEntity = TestData.getGroup();
        groupEntity.setId(null);
        GroupEntity expected = TestData.getGroup();
        when(groupRepository.save(eq(groupEntity))).thenReturn(expected);

        //when
        GroupEntity actual = groupService.save(groupEntity);

        //then
        Mockito.verify(groupRepository, times(1)).save(eq(groupEntity));

    }

    @Test
    public void givenGroup_whenFindById_thenReturnSuccessfulResult(){

        GroupEntity expected = TestData.getGroup();
        Long id = expected.getId();
        when(groupRepository.findById(eq(id))).thenReturn(Optional.of(expected));

        GroupEntity actual = groupService.findById(id);
        verify(groupRepository, times(1)).findById(eq(id));

    }

    @Test
    public void givenGroup_whenFindById_thenExceptionThrows(){

        //given
        GroupEntity expected = TestData.getGroup();
        Long id = expected.getId();
        when(groupRepository.findById(eq(id))).thenReturn(Optional.of(expected));
        Long failedId = 2L;

        //when and then
        assertThrows(String.format("Group with id %d wasn't found", failedId),
                ClassBookException.class,
                () ->groupService.findById(failedId));

        verify(groupRepository, times(1)).findById(eq(failedId));

    }

    @Test
    public void givenGroup_whenDeleteById_thenDeletedSuccessfully(){

        // given
        GroupEntity groupEntity = TestData.getGroup();
        Long id = groupEntity.getId();
        GroupEntity expexted = TestData.getGroup();
        expexted.setDeleted(true);
        when(groupRepository.findById(eq(id))).thenReturn(Optional.of(groupEntity));
        when(groupRepository.save(eq(groupEntity))).thenReturn(expexted);

        //when
        groupService.deleteById(id);

        //then
        verify(groupRepository, times(1)).findById(eq(id));
        verify(groupRepository, times(1)).save(groupEntity);
    }

    @Test
    public void givenGroupList_whenFindAll_thenFoundGroupListSuccessfully(){
        //given
        GroupEntity group = TestData.getGroup();
        List<GroupEntity> expected = List.of(group);
        when(groupRepository.findAll()).thenReturn(expected);

        //when
        Page<GroupEntity> actual = groupService.findAll(Pageable.unpaged());

        //then
        verify(groupRepository, times(1)).findAll(eq(Pageable.unpaged()));
    }

    @Test
    public void givenGroup_whenUpdate_thenUpdatedSuccessfully(){
        //given
        GroupEntity group = TestData.getGroup();
        Long id = group.getId();
        GroupEntity expected = TestData.getGroup();
        expected.setGroupTitle("Updated group");
        when(groupRepository.findById(eq(id))).thenReturn(Optional.of(group));
        when(groupRepository.save(eq(group))).thenReturn(expected);

        //when
        groupService.update(id, group);

        //then
        verify(groupRepository, times(1)).findById(eq(id));
        verify(groupRepository, times(1)).save(eq(group));
    }

}

package com.eschool.classbook.credential;

import com.eschool.classbook.TestData;
import com.eschool.classbook.exception.ClassBookException;
import com.eschool.openapi.v1.api.CredentialsV1Api;
import com.eschool.openapi.v1.model.CommonResponseDto;
import com.eschool.openapi.v1.model.CredentialDto;
import com.eschool.openapi.v1.model.PageViewDto;
import org.junit.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CredentialResourceUnitTest {

    private final CredentialService credentialService = mock(CredentialService.class);
    private final CredentialMapper credentialMapper = mock(CredentialMapper.class);
    private final CredentialsV1Api credentialResource = new CredentialResource(credentialMapper, credentialService);

    @Test
    public void givenCredential_whenSave_thenCredentialSavedSuccessfully(){
        //given
        CredentialEntity credentialEntity = TestData.getCredentialEntity();
        CredentialEntity expected = TestData.getCredentialEntity();
        CredentialDto credentialDto = TestData.getCredentialDto();

        when(credentialService.save(eq(credentialEntity))).thenReturn(expected);
        when(credentialMapper.toEntity(eq(credentialDto))).thenReturn(credentialEntity);

        //when
        ResponseEntity<CommonResponseDto> response = credentialResource.postCredential(credentialDto);

        //then
        verify(credentialService, times(1)).save(eq(credentialEntity));
        verify(credentialMapper, times(1)).toEntity(eq(credentialDto));


    }

    @Test
    public void givenCredential_whenFindById_thenCredentialFoundSuccessfully(){
        //given
        CredentialEntity credentialEntity = TestData.getCredentialEntity();
        Long id = credentialEntity.getId();
        CredentialDto credentialDto = TestData.getCredentialDto();

        when(credentialService.findById(eq(id))).thenReturn(credentialEntity);
        when(credentialMapper.toDto(credentialEntity)).thenReturn(credentialDto);

        //when
        ResponseEntity <CredentialDto> response = credentialResource.getCredentialById(id);

        //then
        verify(credentialService, times(1)).findById(eq(id));
        verify(credentialMapper, times(1)).toDto(credentialEntity);
    }

    @Test
    public void givenCredential_whenFindById_thenExceptionThrows(){
        //given
        Long failedId = 2l;

        when(credentialService.findById(failedId))
                .thenThrow(new ClassBookException(String.format("Credential with id %d was not found", failedId)));

        //when and then
        assertThrows(
                String.format("Credential with id %d was not found", failedId),
                ClassBookException.class,
                () -> credentialResource.getCredentialById(failedId)
        );
    }

    @Test
    public void givenCredentialList_whenFindAll_thenFoundCredentialListSuccessfully(){
        //given
        CredentialEntity credentialEntity = TestData.getCredentialEntity();
        List<CredentialEntity> expected = List.of(credentialEntity);
        PageRequest pageRequest = PageRequest.of(1, 10);

        when(credentialService.findAll(eq(pageRequest))).thenReturn(new PageImpl<>(expected));

        //when
        ResponseEntity<PageViewDto<CredentialDto>> response = credentialResource.getCredentialList(pageRequest);

        //then
        verify(credentialService, times(1)).findAll(eq(pageRequest));
        verify(credentialMapper, times(1)).toDto(credentialEntity);
    }

    @Test
    public void givenCredential_whenUpdate_thenCredentialUpdatedSuccessfully(){
        //given
        CredentialEntity credentialEntity = TestData.getCredentialEntity();
        Long id = credentialEntity.getId();
        CredentialEntity expected = TestData.getCredentialEntity();
        expected.setUsername("Some username");
        CredentialDto credentialDto = TestData.getCredentialDto();
        when(credentialMapper.toEntity(eq(credentialDto))).thenReturn(credentialEntity);
        when(credentialService.update(eq(id), eq(credentialEntity))).thenReturn(expected);

        //when
        ResponseEntity<CommonResponseDto> response = credentialResource.updateCredential(id, credentialDto);

        //then
        verify(credentialService, times(1)).update(eq(id), eq(credentialEntity));
        verify(credentialMapper, times(1)).toEntity(credentialDto);
    }

    @Test
    public void givenCredential_whenDelete_thenCredentialDeletedSuccessfully(){
        //given
        CredentialEntity credentialEntity = TestData.getCredentialEntity();
        Long id = credentialEntity.getId();
        CredentialEntity expected = TestData.getCredentialEntity();
        expected.setDeleted(true);
        doNothing().when(credentialService).deleteById(id);

        //when
        ResponseEntity<CommonResponseDto> response = credentialResource.deleteCredential(id);

        //then
        verify(credentialService, times(1)).deleteById(eq(id));
    }
}

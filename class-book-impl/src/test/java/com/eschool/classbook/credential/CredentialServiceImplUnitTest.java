package com.eschool.classbook.credential;

import com.eschool.classbook.TestData;
import com.eschool.classbook.exception.ClassBookException;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CredentialServiceImplUnitTest {
    private final CredentialRepository credentialRepository = mock(CredentialRepository.class);
    private final CredentialService credentialService = new CredentialServiceImpl(credentialRepository);

    @Test
    public void givenCredential_whenSave_thenCredentialSavedSuccessfully(){
        //given
        CredentialEntity credentialEntity = TestData.getCredentialEntity();
        credentialEntity.setId(null);
        CredentialEntity expected = TestData.getCredentialEntity();
        when(credentialRepository.save(eq(credentialEntity))).thenReturn(expected);

        //when
        CredentialEntity actual = credentialService.save(credentialEntity);

        //then
        verify(credentialRepository, times(1)).save(eq(credentialEntity));
    }

    @Test
    public void givenCredential_whenFindById_thenCredentialFoundSuccessfully(){
        //given
        CredentialEntity expected = TestData.getCredentialEntity();
        Long id = expected.getId();
        when(credentialRepository.findById(eq(id))).thenReturn(Optional.of(expected));

        //when
        credentialService.findById(id);

        //then
        verify(credentialRepository, times(1)).findById(eq(id));
    }

    @Test
    public void givenCredential_whenFindById_thenExceptionThrows(){
        //given
        CredentialEntity expected = TestData.getCredentialEntity();
        Long id = expected.getId();
        Long failedId = 2L;
        when(credentialRepository.findById(eq(id))).thenReturn(Optional.of(expected));

        //when and then
        assertThrows(
                String.format("Credential with id %d was not found", failedId),
                ClassBookException.class,
                () -> credentialService.findById(failedId)
        );
        verify(credentialRepository, times(1)).findById(eq(failedId));
    }

    @Test
    public void givenCredentialList_whenFindAll_thenFoundCredentialListSuccessfully(){
        //given
        CredentialEntity credential = TestData.getCredentialEntity();
        List<CredentialEntity>expected = List.of(credential);
        when(credentialRepository.findAll(eq(Pageable.unpaged()))).thenReturn(new PageImpl<>(expected));

        //when
        Page<CredentialEntity> actual = credentialService.findAll(Pageable.unpaged());

        //then
        verify(credentialRepository, times(1)).findAll(eq(Pageable.unpaged()));
    }

    @Test
    public void givenCredential_whenUpdate_thenCredentialUpdatedSuccessfully(){
        //given
        CredentialEntity credential = TestData.getCredentialEntity();
        Long id = credential.getId();
        String password = "123";
        credential.setPassword(password);
        CredentialEntity expected = TestData.getCredentialEntity();
        when(credentialRepository.findById(eq(id))).thenReturn(Optional.of(credential));
        when(credentialRepository.save(eq(credential))).thenReturn(expected);

        //when
        CredentialEntity actual = credentialService.update(id,credential);

        //then
        verify(credentialRepository, times(1)).findById(eq(id));
        verify(credentialRepository, times(1)).save(eq(credential));
    }

    @Test
    public void givenCredential_whenDelete_thenCredentialDeletedSuccessfully(){
        //given
        CredentialEntity credentialEntity = TestData.getCredentialEntity();
        Long id = credentialEntity.getId();
        CredentialEntity expected = TestData.getCredentialEntity();
        expected.setDeleted(true);
        when(credentialRepository.findById(eq(id))).thenReturn(Optional.of(credentialEntity));
        when(credentialRepository.save(eq(credentialEntity))).thenReturn(expected);

        //when
        credentialService.deleteById(id);

        //then
        verify(credentialRepository, times(1)).findById(eq(id));
        verify(credentialRepository, times(1)).save(eq(credentialEntity));
    }
}

package com.eschool.classbook.credential;

import com.eschool.classbook.BaseIntegrationTest;
import com.eschool.classbook.TestData;
import com.eschool.classbook.exception.ClassBookException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class CredentialServiceIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private CredentialService credentialService;

    @Test
    public void givenCredential_whenSaveCredential_thenSaveSuccessfully(){
        //given
        CredentialEntity expected = TestData.getCredentialEntity();

        //when
        CredentialEntity actual = credentialService.save(expected);

        //then
        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getUsername(), actual.getUsername());
        assertEquals(expected.getPassword(), actual.getPassword());
        assertEquals(expected.isDeleted(), actual.isDeleted());
    }

    @Test
    public void givenCredential_whenFindById_thenReturnSuccessfulResult() {
        //when
        CredentialEntity actual = credentialService.findById(1L);

        //then
        assertNotNull(actual);
        assertEquals(Long.valueOf(1), actual.getId());
        assertEquals("steven_venson", actual.getUsername());
        assertEquals("uwjwwwefwko", actual.getPassword());
        assertFalse(actual.isDeleted());
    }

    @Test
    public void givenCredential_whenFindById_thenExceptionThrows(){
        //given
        Long filedId = 123L;

        //when and then
        assertThrows(String.format("Credential with id %d wasn't found", filedId),
                ClassBookException.class,
                () -> credentialService.findById(filedId));
    }

    @Test
    public void givenCredential_whenDeleteById_thenDeletedSuccessfully(){
        //given
        Long id = 1L;

        //when
        credentialService.deleteById(id);

        //then
        CredentialEntity credentialEntity = credentialService.findById(id);
        assertTrue(credentialEntity.isDeleted());
    }

    @Test
    public void givenCredentialList_whenFindAll_thenFoundCredentialListSuccessfully(){
        //when
        Page<CredentialEntity> credentialEntityPage = credentialService.findAll(PageRequest.of(0, 6));

        //then
        assertEquals(1, credentialEntityPage.getTotalPages());
        assertEquals(6, credentialEntityPage.getTotalElements());
        assertTrue(credentialEntityPage.stream().allMatch(Objects::nonNull));
    }

    @Test
    public void givenCredential_whenUpdate_thenUpdatedSuccessfully(){
        //given
        String newPassword = "Some_password";
        String newLogin = "Some_login";
        Long id = 1L;

        CredentialEntity expected = credentialService.findById(id);
        expected.setPassword(newPassword);
        expected.setUsername(newLogin);

        //when
        credentialService.update(id, expected);

        //then
        assertEquals(newPassword, expected.getPassword());
        assertEquals(newLogin, expected.getUsername());
    }

}

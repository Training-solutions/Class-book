package com.eschool.classbook.credential;

import com.eschool.openapi.v1.api.CredentialsV1Api;
import com.eschool.openapi.v1.model.CommonResponseDto;
import com.eschool.openapi.v1.model.CredentialDto;
import com.eschool.openapi.v1.model.PageViewDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CredentialResource implements CredentialsV1Api {

    private static final String CREDENTIAL_SAVED_RESPONSE_TEXT = "Credential with id - %d saved successfully";
    private static final String CREDENTIAL_UPDATED_RESPONSE_TEXT = "Credential with id - %d updated successfully";
    private static final String CREDENTIAL_DELETED_RESPONSE_TEXT = "Credential with id - %d deleted successfully";

    private final CredentialMapper credentialMapper;
    private  final CredentialService credentialService;


    @Override
    public ResponseEntity<CommonResponseDto> deleteCredential(Long credentialId) {

        return null;
    }

    @Override
    public ResponseEntity<CredentialDto> getCredentialById(Long credentialId) {
        return null;
    }

    @Override
    public ResponseEntity<PageViewDto<CredentialDto>> getCredentialList(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<CommonResponseDto> postCredential(CredentialDto credentialDto) {
        return null;
    }

    @Override
    public ResponseEntity<CommonResponseDto> updateCredential(Long credentialId, CredentialDto credentialDto) {
        return null;
    }
}

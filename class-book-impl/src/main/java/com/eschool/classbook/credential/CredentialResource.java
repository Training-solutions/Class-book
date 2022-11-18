package com.eschool.classbook.credential;

import com.eschool.openapi.v1.api.CredentialsV1Api;
import com.eschool.openapi.v1.model.CommonResponseDto;
import com.eschool.openapi.v1.model.CredentialDto;
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
public class CredentialResource implements CredentialsV1Api {
    private final CredentialMapper credentialMapper;
    private  final CredentialService credentialService;

    @Override
    public ResponseEntity<CommonResponseDto> deleteCredential(Long credentialId) {
        credentialService.deleteById(credentialId);
        return ResponseEntity.ok(
            new CommonResponseDto(credentialId,
                String.format("Credential with id - %d deleted successfully", credentialId)));
    }

    @Override
    public ResponseEntity<CredentialDto> getCredentialById(Long credentialId) {
        CredentialEntity credentialEntity = credentialService.findById(credentialId);
        CredentialDto credentialDto = credentialMapper.toDto(credentialEntity);
        return ResponseEntity.ok(credentialDto);
    }

    @Override
    public ResponseEntity<PageViewDto<CredentialDto>> getCredentialList(Pageable pageable) {
        Page<CredentialEntity> credentials = credentialService.findAll(pageable);
        List<CredentialDto> credentialDtos = credentials.get().map(credentialMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(new PageViewDto<>(credentialDtos));
    }

    @Override
    public ResponseEntity<CommonResponseDto> postCredential(CredentialDto credentialDto) {
        CredentialEntity credentialEntity = credentialMapper.toEntity(credentialDto);
        CredentialEntity savedCredentialEntity = credentialService.save(credentialEntity);
        Long credentialId = savedCredentialEntity.getId();
        return ResponseEntity.ok(
            new CommonResponseDto(savedCredentialEntity.getId(),
                String.format("Credential with id - %d saved successfully",credentialId)));
    }

    @Override
    public ResponseEntity<CommonResponseDto> updateCredential(Long credentialId, CredentialDto credentialDto) {
        CredentialEntity credentialEntity = credentialMapper.toEntity(credentialDto);
        CredentialEntity updatedCredentialEntity = credentialService.update(credentialId, credentialEntity);
        Long savedCredentialId = updatedCredentialEntity.getId();
        return ResponseEntity.ok(
            new CommonResponseDto(savedCredentialId,
                String.format("Credential with id - %d updated successfully", savedCredentialId))
        );
    }
}

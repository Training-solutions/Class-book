package com.eschool.classbook.credential;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CredentialService {
    Page<CredentialEntity> findAll(Pageable pageable);
    CredentialEntity findById(Long id);
    void deleteById(Long id);
    CredentialEntity save(CredentialEntity credentialEntity);
    CredentialEntity update(Long id, CredentialEntity credentialEntity);
}

package com.eschool.classbook.credential;

import com.eschool.classbook.exception.ClassBookException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CredentialServiceImpl implements CredentialService{
    
    private final CredentialRepository credentialRepository;

    public CredentialServiceImpl(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    @Override
    public Page<CredentialEntity> findAll(Pageable pageable) {
        return credentialRepository.findAll(pageable);
    }

    @Override
    public CredentialEntity findById(Long id) {
        return credentialRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Credential with id %d wasn't found", id)));

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        CredentialEntity credential = credentialRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Credential with id %d was not found", id)));
        credential.setDeleted(true);
        credentialRepository.save(credential);
    }

    @Override
    public CredentialEntity save(CredentialEntity credentialEntity) {
        return credentialRepository.save(credentialEntity);
    }

    @Override
    @Transactional
    public CredentialEntity update(Long id, CredentialEntity credentialEntity) {
        credentialRepository.findById(id)
                .orElseThrow(() -> new ClassBookException(String.format("Credential with id %d was not found", id)));
        return credentialRepository.save(credentialEntity);
    }
}

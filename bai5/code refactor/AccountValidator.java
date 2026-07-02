package com.example.ekyc.validation;

import com.example.ekyc.dto.AccountRequest;
import com.example.ekyc.exception.BusinessException;
import com.example.ekyc.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountValidator {

    private final AccountRepository repository;

    public void validate(AccountRequest request) {

        if (request.getFullName() == null || request.getFullName().trim().isEmpty()) {
            throw new BusinessException("Full name is required.");
        }

        if (repository.existsByCitizenId(request.getCitizenId())) {
            throw new BusinessException("Citizen ID already exists.");
        }

        if (repository.existsByPhone(request.getPhone())) {
            throw new BusinessException("Phone number already exists.");
        }

    }

}
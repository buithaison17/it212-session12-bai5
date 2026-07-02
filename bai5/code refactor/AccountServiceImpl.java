package com.example.ekyc.service.impl;

import com.example.ekyc.dto.AccountRequest;
import com.example.ekyc.dto.AccountResponse;
import com.example.ekyc.entity.Account;
import com.example.ekyc.repository.AccountRepository;
import com.example.ekyc.service.AccountService;
import com.example.ekyc.validation.AccountValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final AccountValidator validator;

    @Override
    public AccountResponse register(AccountRequest request) {

        log.info("Start register account: {}", request.getCitizenId());

        validator.validate(request);

        Account account = new Account();

        account.setFullName(request.getFullName());
        account.setPhone(request.getPhone());
        account.setEmail(request.getEmail());
        account.setCitizenId(request.getCitizenId());
        account.setAccountNumber(UUID.randomUUID().toString());

        repository.save(account);

        log.info("Register account success: {}", account.getAccountNumber());

        AccountResponse response = new AccountResponse();
        response.setAccountId(account.getId());
        response.setStatus("PENDING");

        return response;
    }

}
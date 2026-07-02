package com.example.ekyc.service;

import com.example.ekyc.dto.AccountRequest;
import com.example.ekyc.dto.AccountResponse;

public interface AccountService {

    AccountResponse register(AccountRequest request);

}
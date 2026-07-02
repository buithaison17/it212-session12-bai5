package com.example.ekyc.controller;

import com.example.ekyc.dto.AccountRequest;
import com.example.ekyc.dto.AccountResponse;
import com.example.ekyc.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/register")
    public AccountResponse register(@RequestBody AccountRequest request) {

        log.info("Receive register request");

        return accountService.register(request);

    }

}
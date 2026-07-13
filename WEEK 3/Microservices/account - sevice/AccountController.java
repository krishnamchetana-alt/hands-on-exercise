package com.example.accountservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @GetMapping("/status")
    public String getAccountStatus() {
        return "Account Service is active and responding.";
    }
}
package com.example.account;

import java.math.BigDecimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
  @GetMapping("/{accountNumber}")
  public Account getAccount(@PathVariable String accountNumber) {
    return new Account(accountNumber, "Ava Patel", "SAVINGS", new BigDecimal("25000.00"));
  }
  public record Account(String accountNumber, String customerName, String accountType, BigDecimal balance) { }
}

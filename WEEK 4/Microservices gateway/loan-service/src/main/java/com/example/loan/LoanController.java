package com.example.loan;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoanController {
  @GetMapping("/account/{accountNumber}")
  public List<Loan> getLoans(@PathVariable String accountNumber) {
    return List.of(new Loan("LN-1001", accountNumber, "HOME", new BigDecimal("1500000.00"), "ACTIVE"));
  }
  public record Loan(String loanId, String accountNumber, String loanType, BigDecimal amount, String status) { }
}

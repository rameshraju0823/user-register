package com.example.userregisteration.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userregisteration.model.Account;
import com.example.userregisteration.repository.AccountRepository;
import com.example.userregisteration.repository.TransactionRepository;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public Account getAccount(String sortCode, String accountNumber) {
        Optional<Account> account = accountRepository
                .findBySortCodeAndAccountNumber(sortCode, accountNumber);

        account.ifPresent(value ->
                value.setTransactions(transactionRepository
                        .findBySourceAccountIdOrderByInitiationDate(value.getId())));

        return account.orElse(null);
    }
}
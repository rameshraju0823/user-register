package com.example.userregisteration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userregisteration.model.Account;
import com.example.userregisteration.model.Response;
import com.example.userregisteration.model.Transaction;
import com.example.userregisteration.repository.AccountRepository;
import com.example.userregisteration.repository.TransactionRepository;
import com.example.userregisteration.repository.util.TransactionUtil;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public Response makeTransfer(TransactionUtil transactionUtil) {
              String sourceSortCode = transactionUtil.getSourceAccount().getSortCode();
        String sourceAccountNumber = transactionUtil.getSourceAccount().getAccountNumber();
        Optional<Account> sourceAccount = accountRepository
                .findBySortCodeAndAccountNumber(sourceSortCode, sourceAccountNumber);

        String targetSortCode = transactionUtil.getTargetAccount().getSortCode();
        String targetAccountNumber = transactionUtil.getTargetAccount().getAccountNumber();
        Optional<Account> targetAccount = accountRepository
                .findBySortCodeAndAccountNumber(targetSortCode, targetAccountNumber);

        if (sourceSortCode!=null && sourceAccountNumber!=null) {
            if (isAmountAvailable(transactionUtil.getAmount(), sourceAccount.get().getCurrentBalance())) {
            	Transaction transaction = new Transaction();
            	Response responseTransaction = new Response();

                transaction.setAmount(transactionUtil.getAmount());
                transaction.setSourceAccountId(sourceAccount.get().getId());
                transaction.setTargetAccountId(targetAccount.get().getId());
                transaction.setTargetAccountName(targetAccount.get().getAccountName());
                transaction.setInitiationDate(LocalDateTime.now());
                transaction.setCompletionDate(LocalDateTime.now());
                transaction.setReference(transactionUtil.getReference());
              
                updateAccountBalance(sourceAccount.get(), transactionUtil.getAmount());
                Transaction transaction2 = transactionRepository.save(transaction);
                responseTransaction.setAmount(transaction2.getAmount());
                responseTransaction.setReference(transaction2.getReference());
                responseTransaction.setSourceAccountId(transaction2.getTargetAccountId());
                responseTransaction.setTargetAccountName(transaction2.getTargetAccountName());
                return responseTransaction;
            }
        }
        return null;
    }

    private void updateAccountBalance(Account account, double amount) {
        account.setCurrentBalance((account.getCurrentBalance() - amount));
        accountRepository.save(account);
    }

    private boolean isAmountAvailable(double amount, double accountBalance) {
        return (accountBalance - amount) > 0;
    }
}
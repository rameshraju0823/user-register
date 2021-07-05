package com.example.userregisteration.repository.util;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

public class TransactionUtil {

    private AccountUtil sourceAccount;

    private AccountUtil targetAccount;

    @Positive(message = "Transfer amount ")
       @Min(value = 1, message = "Amount must be max than 1")
    private double amount;

    private String reference;

	
    public TransactionUtil() {}

    public AccountUtil getSourceAccount() {
        return sourceAccount;
    }
    public void setSourceAccount(AccountUtil sourceAccount) {
        this.sourceAccount = sourceAccount;
    }
    public AccountUtil getTargetAccount() {
        return targetAccount;
    }
    public void setTargetAccount(AccountUtil targetAccount) {
        this.targetAccount = targetAccount;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    

    @Override
    public String toString() {
        return "TransactionInput{" +
                "sourceAccount=" + sourceAccount +
                ", targetAccount=" + targetAccount +
                ", amount=" + amount +
                ", reference='" + reference + '\'' +
                '}';
    }
}
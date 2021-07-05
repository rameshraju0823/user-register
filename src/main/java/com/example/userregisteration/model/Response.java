package com.example.userregisteration.model;



public class Response {


    private long sourceAccountId;

    private long targetAccountId;

    private String targetAccountName;

    private double amount;

   
    private String reference;


    public Response() {}

  
    public long getSourceAccountId() {
        return sourceAccountId;
    }
    public void setSourceAccountId(long sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }
    public long getTargetAccountId() {
        return targetAccountId;
    }
    public void setTargetAccountId(long targetAccountId) {
        this.targetAccountId = targetAccountId;
    }
    public String getTargetAccountName() {
        return targetAccountName;
    }
    public void setTargetAccountName(String targetAccountName) {
        this.targetAccountName = targetAccountName;
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
        return "Transaction{" +
                "sourceAccountId=" + sourceAccountId +
                ", targetAccountId=" + targetAccountId +
                ", targetAccountName='" + targetAccountName + '\'' +
                ", amount=" + amount +
                ", reference='" + reference + '\'' +
                '}';
    }
}
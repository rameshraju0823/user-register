package com.example.userregisteration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Response {


    private long sourceAccountId;

    private long targetAccountId;

    private String targetAccountName;

    private double amount;

   
    private String reference;


}
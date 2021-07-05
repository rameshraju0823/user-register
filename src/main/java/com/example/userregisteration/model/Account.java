package com.example.userregisteration.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Account {

    @Id
    private long id;

    @Column
    private String sortCode;
    @Column
    private String accountNumber;
    @Column
    private double currentBalance;
    @Column
    private String bankName;
    @Column
    private String accountName;

    @OneToMany(cascade = CascadeType.ALL)
    private transient List<Transaction> transactions;

}
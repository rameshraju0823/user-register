package com.example.userregisteration.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userregisteration.model.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findBySourceAccountIdOrderByInitiationDate(long id);
}
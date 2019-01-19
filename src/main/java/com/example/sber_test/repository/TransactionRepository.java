package com.example.sber_test.repository;

import com.example.sber_test.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findBySender(String sender);

    List<Transaction> findByRecipient(String recipient);
}

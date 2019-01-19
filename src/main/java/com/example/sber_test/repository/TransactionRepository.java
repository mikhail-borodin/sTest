package com.example.sber_test.repository;

import com.example.sber_test.domain.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    @Query( value = "SELECT * FROM Transaction t WHERE t.sender = ?1", nativeQuery = true)
    List<Transaction> findTransactionBySender(String sender);

    @Query( value = "SELECT * FROM Transaction t WHERE t.recipient = ?1", nativeQuery = true)
    List<Transaction> findTransactionByRecipient(String recipient);
}

package com.example.sber_test.service;

import com.example.sber_test.domain.Request;
import com.example.sber_test.domain.Response;
import com.example.sber_test.domain.Transaction;
import com.example.sber_test.domain.Transactions;
import org.springframework.validation.BindingResult;

public interface ITransactionService {
    Response add(Transaction transaction, BindingResult bindingResult);
    Transactions findBySender(Request request);
    Transactions findByRecipient(Request request);
}

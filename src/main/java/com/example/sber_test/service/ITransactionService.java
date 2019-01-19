package com.example.sber_test.service;

import com.example.sber_test.dto.Request;
import com.example.sber_test.dto.Response;
import com.example.sber_test.dto.TransactionDto;
import com.example.sber_test.dto.TransactionsDto;
import org.springframework.validation.BindingResult;

public interface ITransactionService {
    Response newTransaction(TransactionDto transaction, BindingResult bindingResult);
    TransactionsDto findBySender(Request request);
    TransactionsDto findByRecipient(Request request);
}

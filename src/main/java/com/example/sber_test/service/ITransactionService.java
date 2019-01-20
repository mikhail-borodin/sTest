package com.example.sber_test.service;

import com.example.sber_test.dto.RequestDto;
import com.example.sber_test.dto.ResponseDto;
import com.example.sber_test.dto.TransactionDto;
import com.example.sber_test.dto.TransactionsDto;
import org.springframework.validation.BindingResult;

public interface ITransactionService {
    ResponseDto newTransaction(TransactionDto transaction, BindingResult bindingResult);
    TransactionsDto findBySender(RequestDto requestDto);
    TransactionsDto findByRecipient(RequestDto requestDto);
}

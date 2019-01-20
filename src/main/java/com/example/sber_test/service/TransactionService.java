package com.example.sber_test.service;

import com.example.sber_test.domain.Transaction;
import com.example.sber_test.dto.RequestDto;
import com.example.sber_test.dto.ResponseDto;
import com.example.sber_test.dto.TransactionDto;
import com.example.sber_test.dto.TransactionsDto;
import com.example.sber_test.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Service
public class TransactionService implements ITransactionService {

    private static final Logger log = Logger.getLogger(TransactionService.class.getName());

    private final TransactionRepository repository;

    @Autowired
    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public ResponseDto newTransaction(TransactionDto transactionDto, BindingResult bindingResult) {
        log.info("Try add new transaction = " + transactionDto);

        String message;
        List<String> errors = Collections.emptyList();

        if (!bindingResult.hasErrors()) {
            message = "Successfully";
            Transaction transaction = new Transaction(transactionDto.getSender(),
                    transactionDto.getRecipient(), transactionDto.getAmount());

            repository.save(transaction);
            log.info("Transaction " + transactionDto + " added successfully");
        } else {
            errors = getMessagesErrors(bindingResult);
            message = "Error";
            log.info("Error adding transaction " + transactionDto);
        }

        return new ResponseDto(message, errors);
    }

    @Override
    public TransactionsDto findBySender(RequestDto requestDto) {
        log.info("RequestDto findBySender received = " + requestDto);

        return castToTransactionsDto(repository.findBySender(requestDto.getContent()));
    }

    @Override
    public TransactionsDto findByRecipient(RequestDto requestDto) {
        log.info("RequestDto findByRecipient received = " + requestDto);

        return castToTransactionsDto(repository.findByRecipient(requestDto.getContent()));
    }

    private static List<String> getMessagesErrors(BindingResult bindingResult) {
        List<String> errors = new ArrayList<>();

        for (FieldError error : bindingResult.getFieldErrors()) {
            String message = error.getField() + " - " + error.getDefaultMessage();
            errors.add(message);
        }

        return errors;
    }

    private static TransactionsDto castToTransactionsDto(List<Transaction> transactions) {
        List<TransactionDto> tList = new ArrayList<>();

        for (Transaction transaction : transactions) {
            tList.add(new TransactionDto(transaction.getSender(),
                    transaction.getRecipient(),transaction.getAmount()));
        }

        return new TransactionsDto(tList);
    }
}

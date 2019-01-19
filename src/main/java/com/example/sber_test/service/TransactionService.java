package com.example.sber_test.service;

import com.example.sber_test.domain.Transaction;
import com.example.sber_test.dto.Request;
import com.example.sber_test.dto.Response;
import com.example.sber_test.dto.TransactionDto;
import com.example.sber_test.dto.TransactionsDto;
import com.example.sber_test.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class TransactionService implements ITransactionService {

    Logger log = Logger.getLogger(TransactionService.class.getName());

    @Autowired
    private TransactionRepository repository;

    @Override
    @Transactional
    public Response newTransaction(TransactionDto transactionDto, BindingResult bindingResult) {
        log.info("newTransaction = " + transactionDto);

        String message;
        List<String> errors = new ArrayList<>();

        if (!bindingResult.hasErrors()) {
            message = "Successfully";
            Transaction transaction = new Transaction(transactionDto.getSender(),
                    transactionDto.getRecipient(), transactionDto.getAmount());

            repository.save(transaction);
        } else {
            errors = getMessagesErrors(bindingResult);
            message = "Error";
        }

        return new Response(message, errors);
    }

    @Override
    public TransactionsDto findBySender(Request request) {
        log.info("findBySender = " + request);

        return castToTransactionsDto(repository.findBySender(request.getContent()));
    }

    @Override
    public TransactionsDto findByRecipient(Request request) {
        log.info("findByRecipient = " + request);

        return castToTransactionsDto(repository.findByRecipient(request.getContent()));
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

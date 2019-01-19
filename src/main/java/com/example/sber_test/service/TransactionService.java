package com.example.sber_test.service;

import com.example.sber_test.domain.Request;
import com.example.sber_test.domain.Response;
import com.example.sber_test.domain.Transaction;
import com.example.sber_test.domain.Transactions;
import com.example.sber_test.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepository repository;

    @Override
    public Response add(Transaction transaction, BindingResult bindingResult) {
        List<String> errors = getMessagesErrors(bindingResult);
        String message;

        if (!bindingResult.hasErrors()) {
            message = "Successfully";
            repository.save(transaction);
        } else {
            message = "Error";
        }

        return new Response(message, errors);
    }

    @Override
    public Transactions findBySender(Request request) {
        return new Transactions(repository.findTransactionBySender(request.getContent()));
    }

    @Override
    public Transactions findByRecipient(Request request) {
        return new Transactions(repository.findTransactionByRecipient(request.getContent()));
    }

    private static List<String> getMessagesErrors(BindingResult bindingResult) {
        List<String> errors = new ArrayList<>();

        for (FieldError error : bindingResult.getFieldErrors()) {
            String message = error.getField() + " - " + error.getDefaultMessage();
            errors.add(message);
        }

        return errors;
    }

}

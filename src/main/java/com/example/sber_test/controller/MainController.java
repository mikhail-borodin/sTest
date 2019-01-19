package com.example.sber_test.controller;

import com.example.sber_test.dto.Request;
import com.example.sber_test.dto.Response;
import com.example.sber_test.dto.TransactionDto;
import com.example.sber_test.dto.TransactionsDto;
import com.example.sber_test.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MainController {

    @Autowired
    private ITransactionService transactionService;

    @RequestMapping(value = "/getbysender", produces = MediaType.APPLICATION_XML_VALUE)
    public TransactionsDto getTransactionBySender(@Valid @RequestBody Request request) {
        return transactionService.findBySender(request);
    }

    @RequestMapping(value = "/getbyrecipient", produces = MediaType.APPLICATION_XML_VALUE)
    public TransactionsDto getTransactionByRecipient(@Valid @RequestBody Request request) {
        return transactionService.findByRecipient(request);
    }

    @PostMapping(value = "/newtransaction", produces = MediaType.APPLICATION_XML_VALUE)
    public Response newTransaction(@Valid @RequestBody TransactionDto transaction, BindingResult bindingResult) {
        return transactionService.newTransaction(transaction, bindingResult);
    }
}

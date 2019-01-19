package com.example.sber_test.controller;

import com.example.sber_test.domain.Request;
import com.example.sber_test.domain.Response;
import com.example.sber_test.domain.Transaction;
import com.example.sber_test.domain.Transactions;
import com.example.sber_test.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class XMLRestController {

    @Autowired
    private ITransactionService transactionService;

    @RequestMapping(value = "/getbysender", produces = MediaType.APPLICATION_XML_VALUE)
    public Transactions getTransactionBySender(@Valid @RequestBody Request request) {
        return transactionService.findBySender(request);
    }

    @RequestMapping(value = "/getbyrecipient", produces = MediaType.APPLICATION_XML_VALUE)
    public Transactions getTransactionByRecipient(@Valid @RequestBody Request request) {
        return transactionService.findByRecipient(request);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    public Response postTransaction(@Valid @RequestBody Transaction transaction, BindingResult bindingResult) {
        return transactionService.add(transaction, bindingResult);
    }
}

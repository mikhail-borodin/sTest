package com.example.sber_test.controller;

import com.example.sber_test.dto.Request;
import com.example.sber_test.dto.Response;
import com.example.sber_test.dto.TransactionDto;
import com.example.sber_test.dto.TransactionsDto;
import com.example.sber_test.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response BadRequestHandler() {
        return new Response("Error", Arrays.asList("bad request"));
    }

}

package com.example.sber_test.controller;

import com.example.sber_test.dto.RequestDto;
import com.example.sber_test.dto.ResponseDto;
import com.example.sber_test.dto.TransactionDto;
import com.example.sber_test.dto.TransactionsDto;
import com.example.sber_test.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController
public class MainController {

    private final ITransactionService transactionService;

    @Autowired
    public MainController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(value = "/getbysender", produces = MediaType.APPLICATION_XML_VALUE)
    public TransactionsDto getTransactionBySender(@Valid @RequestBody RequestDto requestDto) {
        return transactionService.findBySender(requestDto);
    }

    @PostMapping(value = "/getbyrecipient", produces = MediaType.APPLICATION_XML_VALUE)
    public TransactionsDto getTransactionByRecipient(@Valid @RequestBody RequestDto requestDto) {
        return transactionService.findByRecipient(requestDto);
    }

    @PostMapping(value = "/newtransaction", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseDto newTransaction(@Valid @RequestBody TransactionDto transaction, BindingResult bindingResult) {
        return transactionService.newTransaction(transaction, bindingResult);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseDto BadRequestHandler() {
        return new ResponseDto("Error", Collections.singletonList("bad request"));
    }
}

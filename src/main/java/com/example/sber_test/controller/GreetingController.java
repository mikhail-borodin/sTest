package com.example.sber_test.controller;

import com.example.sber_test.domain.Transaction;
import com.example.sber_test.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private TransactionRepository repository;

    @GetMapping
    public String main(Map<String,Object> model){
        Iterable<Transaction> transactions = repository.findAll();
        model.put("transactions", transactions);

        System.out.println("GetMapping ");

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String sender, @RequestParam String recipient, @RequestParam Double amount, Map<String,Object> model) {

        Transaction transaction = new Transaction(sender, recipient, amount);
        repository.save(transaction);

        Iterable<Transaction> transactions = repository.findAll();
        model.put("transactions", transactions);

        return "main";
    }
}
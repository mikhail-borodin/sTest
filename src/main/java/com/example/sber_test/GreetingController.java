package com.example.sber_test;

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

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String,Object> model){
        Iterable<Transaction> transactions = repository.findAll();
        model.put("transactions", transactions);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String sender, @RequestParam String recipient, @RequestParam String amount, Map<String,Object> model) {
        Transaction transaction = new Transaction(sender, recipient, amount);

        repository.save(transaction);

        Iterable<Transaction> transactions = repository.findAll();
        model.put("transactions", transactions);

        return "main";
    }
}
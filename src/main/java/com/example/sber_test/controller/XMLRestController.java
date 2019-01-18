package com.example.sber_test.controller;

import com.example.sber_test.model.TransactionXML;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XMLRestController {
    @GetMapping("/get")
    public TransactionXML getCustomer(){
        return new TransactionXML("123122342", "345345434534", "2342342342");
    }

    @PostMapping("/post")
    public String postCustomer(@RequestBody TransactionXML transaction){
        System.out.println(transaction);
        return "Done";
    }
}

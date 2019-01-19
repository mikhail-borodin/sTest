package com.example.sber_test.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "transactions")
public class Transactions implements Serializable {

    private static final long serialVersionUID = 12L;

    @JacksonXmlProperty(localName = "transaction")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Transaction> transactions = new ArrayList<>();

    public Transactions() {
    }

    public Transactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}

package com.example.sber_test.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.List;

@JacksonXmlRootElement(localName = "transactions")
public class TransactionsDto implements Serializable {

    private static final long serialVersionUID = 12L;

    @JacksonXmlProperty(localName = "transaction")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<TransactionDto> transactions;

    public TransactionsDto() {
    }

    public TransactionsDto(List<TransactionDto> transactions) {
        this.transactions = transactions;
    }

    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDto> transactions) {
        this.transactions = transactions;
    }
}

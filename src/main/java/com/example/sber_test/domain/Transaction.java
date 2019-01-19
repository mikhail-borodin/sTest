package com.example.sber_test.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@JacksonXmlRootElement(localName = "transaction")
public class Transaction implements Serializable {

    private static final long serialVersionUID = 11L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer id;

    @JacksonXmlProperty
    @NotNull
    @Pattern(regexp = "^[0-9]+$", message = "must contain only digits")
    @Size(min = 5, max = 25)
    private String sender;

    @JacksonXmlProperty
    @NotNull
    @Pattern(regexp = "^[0-9]+$")
    @Size(min = 5, max = 25)
    private String recipient;

    @JacksonXmlProperty
    @NotNull
    @Min(value = 0)
    @Max(value = 300000)
    private Double amount;

    public Transaction() {
    }

    public Transaction(String sender, String recipient, Double amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

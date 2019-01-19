package com.example.sber_test.dto;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.validation.constraints.*;
import java.io.Serializable;

@JacksonXmlRootElement(localName = "transaction")
public class TransactionDto implements Serializable {

    private static final long serialVersionUID = 11L;

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
    @Min(value = 1)
    @Max(value = 300000)
    private Double amount;

    public TransactionDto() {
    }

    public TransactionDto(String sender, String recipient, Double amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
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

    @Override
    public String toString() {
        return "TransactionDto{" +
                "sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", amount=" + amount +
                '}';
    }
}

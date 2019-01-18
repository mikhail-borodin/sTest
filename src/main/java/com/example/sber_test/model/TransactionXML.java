package com.example.sber_test.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TransactionXML {

    private String sender;
    private String recipient;
    private String amount;

    public TransactionXML() {
    }

    public TransactionXML(String sender, String recipient, String amount) {
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

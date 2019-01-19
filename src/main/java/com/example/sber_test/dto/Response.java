package com.example.sber_test.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "Response")
public class Response implements Serializable {
    private static final long serialVersionUID = 14L;

    @JacksonXmlProperty
    private String message;

    @JacksonXmlProperty(localName = "error")
    private List<String> errors = new ArrayList<>();

    public Response() {
    }

    public Response(String message, List<String> errors) {
        this.message = message;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}

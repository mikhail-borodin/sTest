package com.example.sber_test.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.List;

@JacksonXmlRootElement(localName = "ResponseDto")
public class ResponseDto implements Serializable {
    private static final long serialVersionUID = 14L;

    @JacksonXmlProperty
    private String message;

    @JacksonXmlProperty(localName = "error")
    private List<String> errors;

    public ResponseDto() {
    }

    public ResponseDto(String message, List<String> errors) {
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

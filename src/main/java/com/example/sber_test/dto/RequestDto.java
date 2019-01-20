package com.example.sber_test.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

@JacksonXmlRootElement(localName = "request")
public class RequestDto implements Serializable {
    private static final long serialVersionUID = 13L;
    @JacksonXmlProperty
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "content='" + content + '\'' +
                '}';
    }
}

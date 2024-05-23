package com.adrianodts.springframework.xmlconfiguration;

public class MyBean {

    private final String message;

    public MyBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}

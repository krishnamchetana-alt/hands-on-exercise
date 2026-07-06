package com.example.springcore;

public class HelloWorld {
    private String message;

    // Setter method used by Spring to inject the value from the XML
    public void setMessage(String message) {
        this.message = message;
    }

    public void sayHello() {
        System.out.println("Spring says: " + message);
    }
}
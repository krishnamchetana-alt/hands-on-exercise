
package com.example.mavenproject;

public class MessageBean {
    private String customMessage;

    // Setter injection point
    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

    public void printMessage() {
        System.out.println("Status: " + customMessage);
    }
}
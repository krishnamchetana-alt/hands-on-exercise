package com.example.mavenproject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
 public static void main(String[] args) {
        // Initialize Spring container using classpath configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Retrieve the bean and call the printing method
        MessageBean bean = (MessageBean) context.getBean("msgBean");
        bean.printMessage();
    }
}
package com.example.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // 1. Initialize the IoC container by reading the configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. Fetch the managed bean from the container
        HelloWorld obj = (HelloWorld) context.getBean("helloWorldBean");

        // 3. Execute the method
        obj.sayHello();
    }
}
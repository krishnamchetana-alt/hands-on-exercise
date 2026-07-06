package com.example.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Request the Car bean (which has the Engine already injected by Spring)
        Car myCar = (Car) context.getBean("carBean");
        
        // Execute the method
        myCar.drive();
    }
}
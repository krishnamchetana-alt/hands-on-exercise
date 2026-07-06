package com.example.springcore;

public class Car {
    private Engine engine;

    // Setter method for Spring to inject the Engine bean automatically
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        if (engine != null) {
            engine.start();
            System.out.println("Car is driving smoothly!");
        } else {
            System.out.println("Cannot drive, missing an engine!");
        }
    }
}
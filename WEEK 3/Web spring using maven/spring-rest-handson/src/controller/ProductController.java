package com.example.springresthandson.controller;

import com.example.springresthandson.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @GetMapping("/products")
    public List<Product> getProducts() {
        // Returning a mock list of products for the hands-on exercise
        return Arrays.asList(
            new Product(1, "Laptop", 899.99),
            new Product(2, "Smartphone", 499.99),
            new Product(3, "Wireless Headphones", 149.99)
        );
    }
}
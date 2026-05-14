package com.example.cloudstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String products(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Object[] products = restTemplate.getForObject(
                "https://fakestoreapi.com/products", Object[].class
        );
        model.addAttribute("products", products);
        return "products/list";
    }
}
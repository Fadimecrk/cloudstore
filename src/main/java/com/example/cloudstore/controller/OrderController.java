package com.example.cloudstore.controller;

import com.example.cloudstore.model.Order;
import com.example.cloudstore.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/order")
    public String placeOrder(@RequestParam String productTitle,
                             @RequestParam Double productPrice,
                             Principal principal,
                             RedirectAttributes redirectAttributes) {
        Order order = new Order(principal.getName(), productTitle, productPrice);
        orderRepository.save(order);
        redirectAttributes.addFlashAttribute("message", "Beställning lagd för: " + productTitle);
        return "redirect:/products";
    }
}

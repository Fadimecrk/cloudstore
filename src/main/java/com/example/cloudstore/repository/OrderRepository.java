package com.example.cloudstore.repository;

import com.example.cloudstore.model.Order;
import com.example.cloudstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserOrderByOrderedAtDesc(User user);
}
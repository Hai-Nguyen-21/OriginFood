package com.organic.repository;

import com.organic.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    public Order findOrderByIdUserAndStatus(int id, String status);
    public List<Order> findOrderByStatus(String status);
    public List<Order> findOrderByIdUser(int id);
}

package com.organic.service.impl;

import com.organic.entity.Order;
import com.organic.entity.User;
import com.organic.repository.OrderRepository;
import com.organic.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    //thanh toán
    @Override
    public Order updateOrder(int id) {
        Order fromDB = this.orderRepository.findById(id).orElseThrow(null);
        if(fromDB != null){
            fromDB.setStatus("Processing");
            return this.orderRepository.save(fromDB);
        }
        return null;
    }

    @Override
    public Order createNewOrder(User u) {
        Order fromDB = new Order();
        int number = (int) Math.floor(Math.random() * 100);
        String time = String.valueOf(LocalDate.now());
        String date = time.replaceAll("[-+.^:,]","");

        fromDB.setCode("DH"+number+date+u.getId());
        fromDB.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));
        fromDB.setIdUser(u.getId());
        fromDB.setAddress(u.getAddress());
        fromDB.setStatus("Unresolved");
        return this.orderRepository.save(fromDB);
    }

    public Order getOrderByIdAndStatus(int id){
        return this.orderRepository.findOrderByIdUserAndStatus(id, "Unresolved");
    }

    public List<Order> getByStatus(String status){
        return this.orderRepository.findOrderByStatus(status);
    }

    public Order updateByStatus(Order o){
        Order fromDB = this.orderRepository.findById(o.getId()).orElse(null);
        if(fromDB != null){
            fromDB.setStatus(o.getStatus());
            return this.orderRepository.save(fromDB);
        }
        return null;
    }

    public List<Order> getByIdUser(int id){
        return this.orderRepository.findOrderByIdUser(id);
    }
}

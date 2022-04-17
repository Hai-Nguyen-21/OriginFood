package com.organic.controller;

import com.organic.entity.Order;
import com.organic.entity.User;
import com.organic.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody User u){
        return this.orderService.createNewOrder(u);
    }

    @PutMapping("{id}")
    public Order payCart(@PathVariable int id){
        return this.orderService.updateOrder(id);
    }

    @GetMapping("find-order/{id}")
    public Order getOrder(@PathVariable int id){
        return this.orderService.getOrderByIdAndStatus(id);
    }

    @GetMapping("/processing")
    public List<Order> getOrderByProcessing(){
        return this.orderService.getByStatus("Processing");
    }

    @GetMapping("/processed")
    public List<Order> getOrderByProcessed(){
        return this.orderService.getByStatus("processed");
    }

    @GetMapping("/shipping")
    public List<Order> getOrderByShipping(){
        return this.orderService.getByStatus("shipping");
    }

    @GetMapping("/completion")
    public List<Order> getOrderByCompletion(){
        return this.orderService.getByStatus("Completion");
    }

    @GetMapping("/fail")
    public List<Order> getOrderByFail(){
        return this.orderService.getByStatus("Fail");
    }

    @PutMapping("/update")
    public Order updateByStatus(@RequestBody Order o){
        return this.orderService.updateByStatus(o);
    }

    @GetMapping("{id}")
    public List<Order> getAllByIdUser(@PathVariable int id){
        return this.orderService.getByIdUser(id);
    }
}

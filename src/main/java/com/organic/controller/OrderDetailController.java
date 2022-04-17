package com.organic.controller;

import com.organic.entity.OrderDetail;
import com.organic.service.impl.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/orderdetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("{id_order}")
    public List<OrderDetail> getAllOrderDetail(@PathVariable int id_order){
        return this.orderDetailService.getAllByIdOrder(id_order);
    }

    @GetMapping("/total-cart/{id}")
    public int getTotalCartInProduct(@PathVariable int id){
        List<OrderDetail> list = this.orderDetailService.getAllByIdOrder(id);
        return list.size();
    }

    @PostMapping
    public OrderDetail addOrderDetail(@RequestBody OrderDetail od){
        return this.orderDetailService.save(od);
    }

    @PutMapping("{id}")
    public OrderDetail updateOrderDetail(@RequestBody OrderDetail od){
        return this.orderDetailService.update(od);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteOrderDetail(@PathVariable int id){
        this.orderDetailService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/item/{id}")
    public OrderDetail getOrderDetailById(@PathVariable int id){
        return this.orderDetailService.getOneOrderDetail(id);
    }
}

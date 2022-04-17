package com.organic.service;

import com.organic.entity.Order;
import com.organic.entity.User;

public interface IOrderService {
    public Order updateOrder(int id);
    public Order createNewOrder(User u);
}

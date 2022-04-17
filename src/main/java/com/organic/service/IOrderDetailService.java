package com.organic.service;

import com.organic.entity.OrderDetail;

public interface IOrderDetailService {
    public OrderDetail save(OrderDetail od);
    public OrderDetail update(OrderDetail od);
    public void delete(int id);
//    public List<CartDTO> getAllCart(int id);
}

package com.organic.service.impl;

import com.organic.entity.OrderDetail;
import com.organic.repository.OrderDetailRepository;
import com.organic.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public OrderDetail save(OrderDetail od) {
        return this.orderDetailRepository.save(od);
    }

    @Override
    public OrderDetail update(OrderDetail od) {
        OrderDetail fromDB = this.orderDetailRepository.findById(od.getId()).orElse(null);
        System.out.println(fromDB);
        if(fromDB != null){
            fromDB.setQuantity(od.getQuantity());
            double total = od.getQuantity() * od.getPrice();
            fromDB.setTotal(total);
            return this.orderDetailRepository.save(fromDB);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        if(id > 0){
            this.orderDetailRepository.deleteById(id);
        }
    }

//    @Override
//    public List<CartDTO> getAllCart(int id_user){
//        Query query = this.entityManager.createNamedQuery("getCartProduct");
//        query.setParameter(1, id_user);
//        List<CartDTO> list = query.getResultList();
//        return list;
//    }

    public List<OrderDetail> getAllByIdOrder(int id){
        return this.orderDetailRepository.findOrderDetailByIdOrder(id);
    }

    public OrderDetail getOneOrderDetail(int id){
        return this.orderDetailRepository.findOrderDetailById(id);
    }
}

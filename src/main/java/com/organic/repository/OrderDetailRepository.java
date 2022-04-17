package com.organic.repository;

import com.organic.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    @Query(value = "SELECT o FROM OrderDetail o WHERE o.idOrder = ?1")
    List<OrderDetail> findOrderDetailByIdOrder(int id);

    public OrderDetail findOrderDetailById(int id);

//    @Query(value = "SELECT od.idOrder, od.idProduct, od.nameProduct, od.imageProduct, od.price, od.quantity, od.total, o.code, o.createDate, o.idUser, o.address, o.status " +
//            "FROM OrderDetail od JOIN Order o ON od.idOrder = o.id WHERE od.idOrder = ?1 AND o.idUser = 1 AND o.status = 'Unresolved'")

//    List<CartDTO> listCartById(int id);
}

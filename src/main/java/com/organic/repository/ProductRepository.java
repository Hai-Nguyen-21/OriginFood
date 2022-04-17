package com.organic.repository;

import com.organic.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT p FROM Product p WHERE p.idCate = ?1")
    public List<Product> findProductByIdCate(int id);
}

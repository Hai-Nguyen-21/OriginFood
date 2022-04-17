package com.organic.service;

import com.organic.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public List<Product> findAllProduct();
    public Optional<Product> getOneById(int id);
    public void delete(int id);
    public Product save(Product p);
    public Product update(Product p);
}

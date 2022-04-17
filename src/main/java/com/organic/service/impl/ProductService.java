package com.organic.service.impl;

import com.organic.entity.Product;
import com.organic.repository.ProductRepository;
import com.organic.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllProduct() {
        List<Product> list = new ArrayList<>();
        list = this.productRepository.findAll();
        return list.isEmpty() ? null : list;
    }

    @Override
    public Optional<Product> getOneById(int id) {
        if(id < 0){
            return null;
        }
        return this.productRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public Product save(Product p) {
        if(p != null){
            return this.productRepository.save(p);
        }
        return null;
    }

    @Override
    public Product update(Product p) {
        Product fromDB = this.getOneById(p.getId()).orElse(null);
        if(fromDB != null){
            fromDB.setName(p.getName());
            fromDB.setPrice(p.getPrice());
            fromDB.setQuantity(p.getQuantity());
            fromDB.setWeight(p.getWeight());
            fromDB.setStatus(p.getStatus());
            fromDB.setIdCate(p.getIdCate());
            fromDB.setDescription(p.getDescription());
            return this.productRepository.save(fromDB);
        }
        return null;
    }

    public List<Product> findProductByIdCategory(int id){
        return this.productRepository.findProductByIdCate(id);
    }
}

package com.organic.controller;

import com.organic.entity.Product;
import com.organic.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/cateid/{id}")
    public List<Product> getProductByIdCate(@PathVariable int id){
        return this.productService.findProductByIdCategory(id);
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return this.productService.findAllProduct();
    }

    @GetMapping("{id}")
    public Optional<Product> getById(@PathVariable int id){
        return this.productService.getOneById(id);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product p){
        return this.productService.update(p);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product p){
        return this.productService.save(p);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable int id){
        this.productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

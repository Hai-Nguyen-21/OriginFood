package com.organic.controller;

import com.organic.entity.Category;
import com.organic.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories(){
        return this.categoryService.getAllCategory();
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return this.categoryService.save(category);
    }

    @PutMapping
    public Category updateCategory(@RequestBody Category category){
        return this.categoryService.update(category);
    }

    @GetMapping("{id}")
    public Category findById(@PathVariable int id){
        return this.categoryService.findById(id);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteById(@PathVariable int id){
        this.categoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



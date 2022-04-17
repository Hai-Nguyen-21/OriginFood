package com.organic.service.impl;

import com.organic.entity.Category;
import com.organic.repository.CategoryRepository;
import com.organic.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        list = this.categoryRepository.findAll();
        return list;
    }

    @Override
    public Category save(Category c) {
        return this.categoryRepository.save(c);
    }

    @Override
    public Category update(Category c) {
        Category fromdb = this.categoryRepository.findById(c.getId()).orElse(null);
        if(fromdb != null){
            fromdb.setName(c.getName());
            fromdb.setImage(c.getImage());
            return this.categoryRepository.save(fromdb);
        }
        return null;
    }

    @Override
    public Category findById(int id) {
        return this.categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        this.categoryRepository.deleteById(id);
    }
}

package com.organic.service;

import com.organic.entity.Category;

import java.util.List;

public interface ICategoryService {
    public List<Category> getAllCategory();
    public Category save(Category c);
    public Category update(Category c);
    public Category findById(int id);
    public void deleteById(int id);
}

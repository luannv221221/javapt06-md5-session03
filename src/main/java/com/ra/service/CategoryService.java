package com.ra.service;

import com.ra.model.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();
    Category save(Category category);
    Category findById(Long id);
    void delete(Long id);
    Category update(Category category,Long id);
}

package com.ra.service;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product save(Product product);
    Product findById(Long id);
    void delete(Long id);
    Product update(Product product,Long id);
}

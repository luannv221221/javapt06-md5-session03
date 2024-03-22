package com.ra.service;

import com.ra.model.dto.request.ProductRequest;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product save(ProductRequest product);
    Product findById(Long id);
    void delete(Long id);
    Product update(Product product,Long id);
    Page<Product> paginate(Pageable pageable);
    Page<Product> searchByProductName(Pageable pageable,String keyword);
}

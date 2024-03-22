package com.ra.service.impl;

import com.ra.model.dto.request.ProductRequest;
import com.ra.model.entity.Product;
import com.ra.repository.CategoryRepository;
import com.ra.repository.ProductRepository;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(ProductRequest product) {
        // convert từ DTO => Entity
        Product productNew = Product.builder().
                productName(product.getProductName()).
                price(product.getPrice()).
                category(categoryRepository.findById(product.getCategoryId()).orElse(null)).
                build();

        return productRepository.save(productNew);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product update(Product product, Long id) {
        return null;
    }

    @Override
    public Page<Product> paginate(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> searchByProductName(Pageable pageable, String keyword) {
        return productRepository.findAllByProductNameContainingIgnoreCase(pageable,keyword);
    }
}

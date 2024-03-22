package com.ra.controller;

import com.ra.model.dto.request.ProductRequest;
import com.ra.model.entity.Product;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("")
    public ResponseEntity<Page<Product>> getAll(
            @RequestParam(defaultValue = "2",name = "limit") int limit,
            @RequestParam(defaultValue = "0",name = "page") int noPage){
        Pageable pageable = PageRequest.of(noPage,limit);
        Page<Product> products = productService.paginate(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Product> create(@RequestBody ProductRequest productRequest){
        Product  product = productService.save(productRequest);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }
}

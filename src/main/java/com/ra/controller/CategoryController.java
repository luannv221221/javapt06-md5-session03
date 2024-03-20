package com.ra.controller;

import com.ra.model.dto.reponse.CategoryResponse;
import com.ra.model.entity.Category;
import com.ra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<List<CategoryResponse>> getAll(){
        List<CategoryResponse> categories = categoryService.getAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Category category){
        Category newCategory = categoryService.save(category);
        if(newCategory!=null){
            return new ResponseEntity<>(newCategory,HttpStatus.CREATED);
        }
        return new ResponseEntity<>("err",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Category  category = categoryService.findById(id);
        if(category!=null){
            return new ResponseEntity<>(category,HttpStatus.OK);
        }
        return new ResponseEntity<>("khong tim thay",HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Category category){

        Category newCategory = categoryService.update(category,id);
        if(newCategory!=null){
            return new ResponseEntity<>(newCategory,HttpStatus.CREATED);
        }
        return new ResponseEntity<>("err",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

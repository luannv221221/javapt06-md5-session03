package com.ra.service;

import com.ra.exception.CustomException;
import com.ra.model.dto.reponse.CategoryResponse;
import com.ra.model.entity.Category;
import com.ra.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<CategoryResponse> getAll() {
        List<Category> categoryList = categoryRepository.findAll();
//        List<CategoryResponse> list = new ArrayList<>();
//        for (Category category : categoryList) {
//            list.add(new CategoryResponse(category));
//        }
        return categoryList.stream().map(CategoryResponse::new).toList();
    }

    @Override
    public Category save(Category category) throws CustomException  {
        if(categoryRepository.existsByCategoryName(category.getCategoryName())){
            throw new CustomException(category.getCategoryName() + "D ton tai");
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category update(Category category, Long id) {
        if(categoryRepository.findById(id).isPresent()){
            category.setId(id);
            return categoryRepository.save(category);
        }
        return null;
    }
}

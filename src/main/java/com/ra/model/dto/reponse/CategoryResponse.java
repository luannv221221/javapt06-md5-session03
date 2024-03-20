package com.ra.model.dto.reponse;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class CategoryResponse {
    private Long id;
    private String categoryName;
    private Boolean categoryStatus;
    private Integer totalProduct;

    public CategoryResponse(Category category){
        this.id = category.getId();
        this.categoryName = category.getCategoryName();
        this.categoryStatus = category.getCategoryStatus();
        this.totalProduct = category.getProducts().size();
    }

}

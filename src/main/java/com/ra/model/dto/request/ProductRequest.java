package com.ra.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductRequest {
    private String productName;
    private Double price;
    private Long categoryId;

}

package com.ra.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductRequest {
    @NotNull(message = "Tên sản phẩm không rỗng")
    private String productName;
    @Min(value = 1,message = "Giá phải lớn hơn 0")
    private Double price;
    private Long categoryId;

}

package com.monchisfrozenfood.controller.request;

import jakarta.persistence.Column;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryRequest {
    private Long productCategoryId;
    private String productCategoryName;
}

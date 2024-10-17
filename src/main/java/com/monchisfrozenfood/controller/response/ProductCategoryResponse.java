package com.monchisfrozenfood.controller.response;

import jakarta.persistence.Column;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryResponse {
    private Long productCategoryId;
    private String productCategoryName;
}

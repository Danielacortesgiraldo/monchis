package com.monchisfrozenfood.controller.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSubCategoryResponse {
    private Long productSubCategoryId;
    private String productSubCategoryName;
    private ProductCategoryResponse productCategoryResponse;
}

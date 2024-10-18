package com.monchisfrozenfood.controller.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSubCategoryRequest {
    private Long productSubCategoryId;
    private String productSubCategoryName;
    private Long fkProductCategoryId;
}

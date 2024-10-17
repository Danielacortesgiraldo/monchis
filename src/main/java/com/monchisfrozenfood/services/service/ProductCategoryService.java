package com.monchisfrozenfood.services.service;

import com.monchisfrozenfood.controller.request.ProductCategoryRequest;
import com.monchisfrozenfood.controller.response.ProductCategoryResponse;
import com.monchisfrozenfood.entitys.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getProductCategoriesList();
    ProductCategoryResponse searchProductCategory(Long productCategoryId);
    void saveProductCategory(ProductCategoryRequest productCategoryRequest);
    void updateProductCategory(ProductCategoryRequest productCategoryRequest);
    void deleteProductCategoryById(Long productCategoryId);
}

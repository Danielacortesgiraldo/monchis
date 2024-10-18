package com.monchisfrozenfood.services.service;

import com.monchisfrozenfood.controller.request.ProductSubCategoryRequest;
import com.monchisfrozenfood.controller.response.ProductSubCategoryResponse;
import com.monchisfrozenfood.entitys.ProductSubCategory;

import java.util.List;

public interface ProductSubCategoryService {
    List<ProductSubCategory> getProductSubCategoriesList();
    ProductSubCategoryResponse searchProductSubCategory(Long productSubCategoryId);
    void saveProductSubCategory(ProductSubCategoryRequest productSubCategoryRequest);
    void updateProductSubCategory(ProductSubCategoryRequest productSubCategoryRequest);
    void deleteProductSubCategory(Long productSubCategoryId);
}

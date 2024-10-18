package com.monchisfrozenfood.services;

import com.monchisfrozenfood.controller.request.ProductSubCategoryRequest;
import com.monchisfrozenfood.controller.response.ProductCategoryResponse;
import com.monchisfrozenfood.controller.response.ProductSubCategoryResponse;
import com.monchisfrozenfood.entitys.ProductCategory;
import com.monchisfrozenfood.entitys.ProductSubCategory;
import com.monchisfrozenfood.entitys.repository.ProductSubCategoryRepository;
import com.monchisfrozenfood.services.service.ProductSubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductSubCategoryServiceImpl implements ProductSubCategoryService {
    private final ProductSubCategoryRepository productSubCategoryRepository;

    @Override
    public List<ProductSubCategory> getProductSubCategoriesList() {
        return productSubCategoryRepository.productSubCategoriesList();
    }

    @Override
    public ProductSubCategoryResponse searchProductSubCategory(Long productSubCategoryId) {
        ProductSubCategory productSubCategory = productSubCategoryRepository.searchProductSubCategory(productSubCategoryId);

        return Objects.nonNull(productSubCategory)
                ? buildProductSubCategoryResponse(productSubCategory)
                : ProductSubCategoryResponse.builder().build();
    }

    @Override
    public void saveProductSubCategory(ProductSubCategoryRequest productSubCategoryRequest) {
        if (Objects.nonNull(productSubCategoryRequest)) {
            ProductSubCategory productSubCategory = buildProductSubCategoryEntity(productSubCategoryRequest);
            productSubCategoryRepository.save(productSubCategory);
        }

    }

    @Override
    public void updateProductSubCategory(ProductSubCategoryRequest productSubCategoryRequest) {
        if (Objects.nonNull(productSubCategoryRequest)) {
            Optional<ProductSubCategory> productSubCategory = productSubCategoryRepository.findById(productSubCategoryRequest.getProductSubCategoryId());

            if (productSubCategory.isPresent()) {
                ProductSubCategory updateProductSubCategory = buildProductSubCategoryEntity(productSubCategoryRequest);
                productSubCategoryRepository.save(updateProductSubCategory);
            }
        }
    }

    @Override
    public void deleteProductSubCategory(Long productSubCategoryId) {
        productSubCategoryRepository.deleteById(productSubCategoryId);
    }

    private static ProductSubCategoryResponse buildProductSubCategoryResponse(ProductSubCategory productSubCategory) {
        return ProductSubCategoryResponse.builder()
                .productSubCategoryId(productSubCategory.getProductSubCategoryId())
                .productSubCategoryName(productSubCategory.getProductSubCategoryName())
                .productCategoryResponse(buildProductCategoryResponse(productSubCategory.getFkProductCategoryId()))
                .build();
    }

    private static ProductCategoryResponse buildProductCategoryResponse(ProductCategory productCategory) {
        return ProductCategoryResponse.builder()
                .productCategoryId(productCategory.getProductCategoryId())
                .productCategoryName(productCategory.getProductCategoryName())
                .build();
    }

    private static ProductSubCategory buildProductSubCategoryEntity(ProductSubCategoryRequest productSubCategoryRequest) {
        return ProductSubCategory.builder()
                .productSubCategoryId(productSubCategoryRequest.getProductSubCategoryId())
                .productSubCategoryName(productSubCategoryRequest.getProductSubCategoryName())
                .fkProductCategoryId(buildProductCategoryEntity(productSubCategoryRequest))
                .build();
    }

    private static ProductCategory buildProductCategoryEntity(ProductSubCategoryRequest productSubCategoryRequest) {
        return ProductCategory.builder()
                .productCategoryId(productSubCategoryRequest.getFkProductCategoryId())
                .build();
    }
}

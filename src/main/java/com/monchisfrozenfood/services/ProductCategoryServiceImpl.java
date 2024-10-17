package com.monchisfrozenfood.services;



import com.monchisfrozenfood.controller.request.ProductCategoryRequest;
import com.monchisfrozenfood.controller.response.ProductCategoryResponse;
import com.monchisfrozenfood.entitys.ProductCategory;
import com.monchisfrozenfood.entitys.repository.ProductCategoryRepository;
import com.monchisfrozenfood.services.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> getProductCategoriesList() {
        return  productCategoryRepository.productCategoriesList();
    }

    @Override
    public ProductCategoryResponse searchProductCategory(Long productCategoryId) {
        ProductCategory productCategory = productCategoryRepository.searchProductCategory(productCategoryId);

        return Objects.nonNull(productCategory)
                ? buildProductCategoryResponse(productCategory)
                : ProductCategoryResponse.builder().build();
    }

    @Override
    public void saveProductCategory(ProductCategoryRequest productCategoryRequest) {
        if (Objects.nonNull(productCategoryRequest)) {
            ProductCategory productCategory = buildProductCategoryEntity(productCategoryRequest);
            productCategoryRepository.save(productCategory);
        }
    }

    @Override
    public void updateProductCategory(ProductCategoryRequest productCategoryRequest) {
        if (Objects.nonNull(productCategoryRequest)) {
            Optional<ProductCategory> productCategory = productCategoryRepository.findById(productCategoryRequest.getProductCategoryId());

            if (productCategory.isPresent()) {
                ProductCategory updateProductCategory = buildProductCategoryEntity(productCategoryRequest);
                productCategoryRepository.save(updateProductCategory);
            }
        }
    }

    @Override
    public void deleteProductCategoryById(Long productCategoryId) {
        productCategoryRepository.deleteById(productCategoryId);
    }

    private static ProductCategoryResponse buildProductCategoryResponse(ProductCategory productCategory) {
        return ProductCategoryResponse.builder()
                .productCategoryId(productCategory.getProductCategoryId())
                .productCategoryName(productCategory.getProductCategoryName())
                .build();
    }

    private static ProductCategory buildProductCategoryEntity(ProductCategoryRequest productCategoryRequest) {
        return ProductCategory.builder()
                .productCategoryId(productCategoryRequest.getProductCategoryId())
                .productCategoryName(productCategoryRequest.getProductCategoryName())
                .build();
    }
}

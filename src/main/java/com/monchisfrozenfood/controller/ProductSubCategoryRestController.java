package com.monchisfrozenfood.controller;

import com.monchisfrozenfood.controller.request.ProductSubCategoryRequest;
import com.monchisfrozenfood.controller.response.ProductSubCategoryResponse;
import com.monchisfrozenfood.entitys.ProductSubCategory;
import com.monchisfrozenfood.services.service.ProductSubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productSubCategory")
@RequiredArgsConstructor
public class ProductSubCategoryRestController {
    private final ProductSubCategoryService productSubCategoryService;
    String message = "Operation completed successfully.";

    @GetMapping("/list")
    public ResponseEntity<List<ProductSubCategory>> listProductSubCategoriesApi() {
        List<ProductSubCategory> productSubCategoryList = productSubCategoryService.getProductSubCategoriesList();
        return new ResponseEntity<>(productSubCategoryList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/search/{productSubCategoryId}")
    public ResponseEntity<ProductSubCategoryResponse> searchProductSubCategory(@PathVariable Long productSubCategoryId) {
        ProductSubCategoryResponse productSubCategoryResponse = productSubCategoryService.searchProductSubCategory(productSubCategoryId);
        return ResponseEntity.accepted().body(productSubCategoryResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveProductSubCategory(@RequestBody ProductSubCategoryRequest productSubCategoryRequest) {
        productSubCategoryService.saveProductSubCategory(productSubCategoryRequest);
        return ResponseEntity.accepted().body(message);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateProductSubCategory(@RequestBody ProductSubCategoryRequest productSubCategoryRequest) {
        productSubCategoryService.updateProductSubCategory(productSubCategoryRequest);
        return ResponseEntity.accepted().body(message);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProductSubCategory(@RequestParam(name = "productSubCategoryId") Long productSubCategoryId) {
        productSubCategoryService.deleteProductSubCategory(productSubCategoryId);
        return ResponseEntity.accepted().body(message);
    }
}

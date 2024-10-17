package com.monchisfrozenfood.controller;

import com.monchisfrozenfood.controller.request.ProductCategoryRequest;
import com.monchisfrozenfood.controller.response.ProductCategoryResponse;
import com.monchisfrozenfood.entitys.ProductCategory;
import com.monchisfrozenfood.services.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productCategory")
@RequiredArgsConstructor
public class ProductCategoryRestController {
    private final ProductCategoryService productCategoryService;
    String message = "Operation completed successfully.";

    @GetMapping("/list")
    public ResponseEntity<List<ProductCategory>> listProductCategoriesApi() {
        List<ProductCategory> productCategoriesList = productCategoryService.getProductCategoriesList();
        return new ResponseEntity<>(productCategoriesList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/search/{productCategoryId}")
    public ResponseEntity<ProductCategoryResponse> searchProductCategoryApi(@PathVariable Long productCategoryId) {
        ProductCategoryResponse productCategoryResponse = productCategoryService.searchProductCategory(productCategoryId);
        return ResponseEntity.accepted().body(productCategoryResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveProductCategoryApi(@RequestBody ProductCategoryRequest productCategoryRequest) {
        productCategoryService.saveProductCategory(productCategoryRequest);
        return ResponseEntity.accepted().body(message);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateProductCategoryApi(@RequestBody ProductCategoryRequest productCategoryRequest) {
        productCategoryService.updateProductCategory(productCategoryRequest);
        return ResponseEntity.accepted().body(message);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProductCategoryApi(@RequestParam(name = "productCategoryId") Long productCategoryId) {
        productCategoryService.deleteProductCategoryById(productCategoryId);
        return ResponseEntity.accepted().body(message);
    }
}

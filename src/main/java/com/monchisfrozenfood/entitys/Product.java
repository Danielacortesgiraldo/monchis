package com.monchisfrozenfood.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.cert.CertPathBuilder;

@Entity
@Table(name = "products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "product_cost", nullable = false)
    private Long productCost;

    @ManyToOne
    @JoinColumn(name = "fk_product_sub_category_id", referencedColumnName = "product_sub_category_id", nullable = false)
    private ProductSubCategory fkProductSubCategoryId;

}

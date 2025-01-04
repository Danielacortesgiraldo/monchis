package com.monchisfrozenfood.entitys;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_details")
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long orderDetailId;

    @ManyToOne
    @JoinColumn(name = "fk_product_id", referencedColumnName = "product_category_id", nullable = false)
    private ProductCategory fkProductId;

    @Column(name = "product_quantity", nullable = false)
    private Long productQuantity;

    @ManyToOne
    @JoinColumn(name = "fk_order_id", referencedColumnName = "order_id", nullable = false)
    private Order fkOrderId;
}

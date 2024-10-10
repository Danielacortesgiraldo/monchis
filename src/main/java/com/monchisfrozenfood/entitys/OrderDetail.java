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

    @Column(name = "fk_product_id", nullable = false)
    private Long fkProductId;

    @Column(name = "product_quantity", nullable = false)
    private Long productQuantity;

    @ManyToOne
    @JoinColumn(name = "fk_order_id", referencedColumnName = "order_id", nullable = false)
    private Long fkOrderId;
}

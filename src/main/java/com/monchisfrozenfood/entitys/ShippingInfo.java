package com.monchisfrozenfood.entitys;

import com.monchisfrozenfood.constants.City;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "shipping_info")
@Data

public class ShippingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_id")
    private Long shippingId;

    @Column(name = "shipping_recipient_name", nullable = false)
    private String shippingRecipientName;

    @Column(name = "shipping_adress", nullable = false)
    private String shippingAdress;

    @Column(name = "city", nullable = false)
    private City city;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "fk_order_id", referencedColumnName = "order_id", nullable = false)
    private Long fkOrderId;
}

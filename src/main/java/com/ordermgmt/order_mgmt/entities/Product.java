package com.ordermgmt.order_mgmt.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String name;

    private Integer price;

    private Integer selling_price;

    private Integer stock_qty;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}

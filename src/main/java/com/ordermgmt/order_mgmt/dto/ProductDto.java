package com.ordermgmt.order_mgmt.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ProductDto {

    private Integer productId;

    private String name;

    private Integer price;

    private Integer selling_price;

    private Integer stock_qty;


}

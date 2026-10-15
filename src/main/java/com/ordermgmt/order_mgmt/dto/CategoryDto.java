package com.ordermgmt.order_mgmt.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {

    private Integer categoryId;

    private String categoryName;

    private String categoryDescription;

}

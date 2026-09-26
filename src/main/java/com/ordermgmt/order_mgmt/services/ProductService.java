package com.ordermgmt.order_mgmt.services;

import com.ordermgmt.order_mgmt.dto.ProductDto;
import com.ordermgmt.order_mgmt.entities.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();

    Product addNewProduct(Product product);

    Product editProduct(Product product, Integer productId);

    void deleteProduct(Integer productId);
}

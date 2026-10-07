package com.ordermgmt.order_mgmt.controller;


import com.ordermgmt.order_mgmt.dto.ProductDto;
import com.ordermgmt.order_mgmt.entities.Product;
import com.ordermgmt.order_mgmt.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class APIController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> productDto = this.productService.getAllProducts();
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PostMapping(value = "/addNewProduct")
    public ResponseEntity<Product> addNewProduct(
            @RequestParam("name") String name,
            @RequestParam("price") Integer price,
            @RequestParam("selling_price") Integer selling_price,
            @RequestParam("stock_qty") Integer stock_qty,
            @RequestParam("description") String description
    )
    {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setSelling_price(selling_price);
        product.setStock_qty(stock_qty);
        product.setDescription(description);

        Product newProduct = this.productService.addNewProduct(product);
        return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/editProduct/{productId}")
    public ResponseEntity<Product> editProduct(
        @RequestParam("name") String name,
        @RequestParam("price") Integer price,
        @RequestParam("selling_price") Integer selling_price,
        @RequestParam("stock_qty") Integer stock_qty,
        @RequestParam("description") String description,
        @PathVariable Integer productId)
    {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setSelling_price(selling_price);
        product.setStock_qty(stock_qty);
        product.setDescription(description);

        Product updateProduct = this.productService.editProduct(product, productId);
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        this.productService.deleteProduct(productId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}

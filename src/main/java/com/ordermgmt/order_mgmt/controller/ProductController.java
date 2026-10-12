package com.ordermgmt.order_mgmt.controller;

import com.ordermgmt.order_mgmt.entities.Product;
import com.ordermgmt.order_mgmt.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProductController {

    @Autowired
    public ProductService productService;


    @GetMapping("/product")
    public String getALlProducts(Model model){
        model.addAttribute("pageTitle", "Product List");
        model.addAttribute("productList", productService.getAllProducts());
        model.addAttribute("product", new Product());
        return "product/index";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product")Product product){
        //save a product data to db
        productService.addNewProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/product/{productId}")
    @ResponseBody
    public Product getProductDetail(@PathVariable Integer productId){
        return productService.getProductById(productId);
    }

    @PostMapping("/editProduct")
    public String editProduct(@ModelAttribute("product") Product product){
        //update a product data of db
        Integer productId = product.getProductId();
        productService.editProduct(product, productId);
        return "redirect:/product";
    }

    @DeleteMapping("/deleteProduct/{productId}")
    @ResponseBody
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer productId){
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

}

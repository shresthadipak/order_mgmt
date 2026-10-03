package com.ordermgmt.order_mgmt.controller;

import com.ordermgmt.order_mgmt.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProductController {

    @Autowired
    public ProductService productService;


    @GetMapping("/product")
    public String getALlProducts(Model model){
        model.addAttribute("pageTitle", "Product List");
        model.addAttribute("productList", productService.getAllProducts());
        return "product/index";
    }

}

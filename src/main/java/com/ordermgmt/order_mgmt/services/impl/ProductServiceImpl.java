package com.ordermgmt.order_mgmt.services.impl;

import com.ordermgmt.order_mgmt.dto.ProductDto;
import com.ordermgmt.order_mgmt.entities.Product;
import com.ordermgmt.order_mgmt.repositories.ProductRepo;
import com.ordermgmt.order_mgmt.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<ProductDto>  getAllProducts(){
        List<Product> allproducts = this.productRepo.findAll();
        List<ProductDto> productDtos= allproducts.stream()
                .map(product-> this.modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public Product addNewProduct(Product product){
        Product productInfo = this.modelMapper.map(product, Product.class);
        Product newProduct = this.productRepo.save(productInfo);
        return this.modelMapper.map(newProduct, Product.class);
    }

    @Override
    public Product editProduct(Product product, Integer productId){
        Product productInfo = this.productRepo.findById(productId).orElseThrow();
        productInfo.setName(product.getName());
        productInfo.setPrice(product.getPrice());
        productInfo.setSelling_price(product.getSelling_price());
        productInfo.setStock_qty(product.getStock_qty());
        productInfo.setDescription(product.getDescription());

        Product updateProduct = this.productRepo.save(productInfo);
        return this.modelMapper.map(updateProduct, Product.class);
    }

    @Override
    public void deleteProduct(Integer productId){
        Product product = this.productRepo.findById(productId).orElseThrow();
        this.productRepo.delete(product);
    }
}

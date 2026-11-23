package com.ordermgmt.order_mgmt.services;

import com.ordermgmt.order_mgmt.entities.Product;
import com.ordermgmt.order_mgmt.repositories.ProductRepo;
import com.ordermgmt.order_mgmt.services.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepo productRepo;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void shouldCreateProductSuccessfully(){

        // 1. Arrange: Prepare test objects
        Product inputProduct = new Product();
        Product mappedProduct = new Product();
        Product savedProduct = new Product();
        Product responseProduct = new Product();

        // Mock ModelMapper's first mapping
        when(modelMapper.map(inputProduct, Product.class))
                .thenReturn(mappedProduct);

        // Mock repository save operation
        when(productRepo.save(mappedProduct))
                .thenReturn(savedProduct);

        // Mock ModelMapper's second mapping
        when(modelMapper.map(savedProduct, Product.class))
                .thenReturn(responseProduct);

        // 2. Act: Execute actual service method
        Product result = productService.addNewProduct(inputProduct);

        // 3. Assert: Verify the result
        assertNotNull(result);
        assertSame(responseProduct, result);

        // verify method calls
        verify(modelMapper).map(inputProduct, Product.class);
        verify(productRepo).save(mappedProduct);
        verify(modelMapper).map(savedProduct, Product.class);
    }

}

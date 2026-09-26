package com.ordermgmt.order_mgmt.repositories;

import com.ordermgmt.order_mgmt.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}

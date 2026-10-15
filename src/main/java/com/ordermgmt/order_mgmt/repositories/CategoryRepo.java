package com.ordermgmt.order_mgmt.repositories;

import com.ordermgmt.order_mgmt.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    List<Category> findAllByOrderByCategoryIdDesc();
}

package com.ordermgmt.order_mgmt.services;

import com.ordermgmt.order_mgmt.dto.CategoryDto;
import com.ordermgmt.order_mgmt.entities.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategories();

    Category addNewCategory(Category category);

    Category editCategory(Category category, Integer categoryId);

    void deleteCategory(Integer categoryId);

    Category getCategoryById(Integer categoryId);

}

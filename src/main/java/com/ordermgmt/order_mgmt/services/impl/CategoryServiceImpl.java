package com.ordermgmt.order_mgmt.services.impl;

import com.ordermgmt.order_mgmt.dto.CategoryDto;
import com.ordermgmt.order_mgmt.entities.Category;
import com.ordermgmt.order_mgmt.repositories.CategoryRepo;
import com.ordermgmt.order_mgmt.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<CategoryDto> getAllCategories(){
        List<Category> allCategories = this.categoryRepo.findAllByOrderByCategoryIdDesc();
        List<CategoryDto> categoryDtos = allCategories.stream()
                .map(category -> this.modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
        return categoryDtos;
    }

    @Override
    public Category addNewCategory(Category category){
        Category categoryInfo = this.modelMapper.map(category, Category.class);
        Category newCategory = this.categoryRepo.save(categoryInfo);
        return this.modelMapper.map(newCategory, Category.class);
    }

    @Override
    public Category editCategory(Category category, Integer categoryId){
        Category categoryInfo = this.categoryRepo.findById(categoryId).orElseThrow();
        categoryInfo.setCategoryName(category.getCategoryName());
        categoryInfo.setCategoryDescription(category.getCategoryDescription());

        Category updateCategory = this.categoryRepo.save(categoryInfo);
        return this.modelMapper.map(updateCategory, Category.class);
    }

    @Override
    public void deleteCategory(Integer categoryId){
        Category category = this.categoryRepo.findById(categoryId).orElseThrow();
        this.categoryRepo.delete(category);
    }

    @Override
    public Category getCategoryById(Integer categoryId){
        Category category = this.categoryRepo.findById(categoryId).orElseThrow();
        return category;
    }

}

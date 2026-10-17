package com.ordermgmt.order_mgmt.controller;

import com.ordermgmt.order_mgmt.entities.Category;
import com.ordermgmt.order_mgmt.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @GetMapping("/category")
    public String getAllCategory(Model model){
        model.addAttribute("pageTitle", "Category List");
        model.addAttribute("categoryList", categoryService.getAllCategories());
        model.addAttribute("category", new Category());
        return "category/index";
    }

    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute("category")Category category){
        //save a category data
        categoryService.addNewCategory(category);
        return "redirect:/category";
    }


}

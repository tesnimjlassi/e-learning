package com.securityModel.controllers;

import com.securityModel.models.Category;
import com.securityModel.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("categories")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/add")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }
    @GetMapping("/all")
    public List<Category> categoryList(){
        return categoryService.allCategories();

    }
    @GetMapping("/getone/{id}")
    public Category categoryById(@PathVariable Long id){
        return categoryService.categoryById(id);
    }
    @PutMapping("/update/{id}")
    public Category updateCategory(@PathVariable Long id,@RequestBody Category category){
        return categoryService.updateCategory(id,category);
    }
    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deletecategory(@PathVariable long id) {
        Category p = categoryService.categoryById(id);

        HashMap message = new HashMap();
        if (p != null) {
            try {

                categoryService.deleteCategory(id);
                message.put("etat", "category deleted");
                return message;
            } catch (Exception e) {
                message.put("etat", "Error" + e.getMessage());
                return message;
            }
        } else {
            message.put("etat", "category not found");
            return message;

        }
    }
}

package com.securityModel.service.Impl;

import com.securityModel.models.Category;
import com.securityModel.repository.CategoryRepositopry;
import com.securityModel.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
   private CategoryRepositopry categoryRepositopry;
    @Override
    public Category
    createCategory(Category category){
        return categoryRepositopry.save(category);
    }
    @Override
    public List<Category>
    allCategories(){
        return   categoryRepositopry.findAll();
    }
    @Override
    public Category
    categoryById(Long id){
        return categoryRepositopry.findById(id).orElseThrow(null);
    }
    @Override
    public Category
    updateCategory(Long id,Category category){
        Category cat=categoryRepositopry.findById(id).orElseThrow(null);
        if (cat!=null){
            category.setId(id);
            return categoryRepositopry.save(category);
        }else {
            throw new RuntimeException("Error!");
        }

    }
    @Override
    public void deleteCategory(Long id){
        categoryRepositopry.deleteById(id);
    }

}

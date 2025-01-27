package com.shoppingv1.shop.application.UserCase.Category.Commands.DeleteCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shoppingv1.shop.core.Ports.services.CategoryService;
import com.shoppingv1.shop.application.UserCase.Query;
import com.shoppingv1.shop.core.Exceptions.ResourceNotFoundException;

@Service
public class DeleteCategoryHandler implements Query<Long, Void> {

    private final CategoryService categoryService;

    @Autowired
    public DeleteCategoryHandler(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<Void> handle(Long id) {
        if (categoryService.existsById(id)) {
            categoryService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        throw new ResourceNotFoundException("Category not found with id: " + id);
    }
}

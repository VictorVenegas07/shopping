package com.shoppingv1.shop.application.UserCase.Category.Commands.UpdateCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shoppingv1.shop.core.Exceptions.ResourceNotFoundException;
import com.shoppingv1.shop.core.Ports.services.CategoryService;
import com.shoppingv1.shop.application.Mappers.interfaces.CategoryMapper;
import com.shoppingv1.shop.application.UserCase.Query;
import com.shoppingv1.shop.application.UserCase.Category.Dtos.CategoryDto;

@Service
public class UpdateCategoryHandler implements Query<UpdateCategoryCommand, CategoryDto> {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Autowired
    public UpdateCategoryHandler(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public ResponseEntity<CategoryDto> handle(UpdateCategoryCommand command) {
        return categoryService.findById(command.getId())
                .map(category -> {
                    category.setName(command.getName());
                    category.setDescription(command.getDescription());
                    categoryService.save(category);
                    return ResponseEntity.ok(categoryMapper.toCategoryDto(category));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }
}

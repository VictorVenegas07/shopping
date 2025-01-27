package com.shoppingv1.shop.application.UserCase.Category.Commands.CreateCategory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shoppingv1.shop.core.Ports.services.CategoryService;
import com.shoppingv1.shop.core.domain.Category;
import com.shoppingv1.shop.application.Mappers.interfaces.CategoryMapper;

import com.shoppingv1.shop.application.UserCase.Query;
import com.shoppingv1.shop.application.UserCase.Category.Dtos.CategoryDto;

@Service
public class CreateCategoryHandler implements Query<CreateCategoryCommand, CategoryDto> {

    private final CategoryService CategoryService;
    private final CategoryMapper CategoryMapper;
    
    @Autowired
    public CreateCategoryHandler(CategoryService CategoryService, CategoryMapper CategoryMapper) {
        this.CategoryService = CategoryService;
        this.CategoryMapper = CategoryMapper;
    }

    @Override
    public ResponseEntity<CategoryDto> handle(CreateCategoryCommand request) {
        
        Category category = CategoryMapper.toCategory(request);

        CategoryService.save(category);

        CategoryDto categoryDto = CategoryMapper.toCategoryDto(category);

        return ResponseEntity.ok(categoryDto);
    }

}

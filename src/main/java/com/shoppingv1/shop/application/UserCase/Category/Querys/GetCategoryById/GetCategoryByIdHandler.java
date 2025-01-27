package com.shoppingv1.shop.application.UserCase.Category.Querys.GetCategoryById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shoppingv1.shop.core.Ports.services.CategoryService;
import com.shoppingv1.shop.application.Mappers.interfaces.CategoryMapper;
import com.shoppingv1.shop.application.UserCase.Query;
import com.shoppingv1.shop.application.UserCase.Category.Dtos.CategoryDto;

@Service
public class GetCategoryByIdHandler implements Query<Long, CategoryDto> {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Autowired
    public GetCategoryByIdHandler(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public ResponseEntity<CategoryDto> handle(Long id) {
        return categoryService.findById(id)
                .map(category -> ResponseEntity.ok(categoryMapper.toCategoryDto(category)))
                .orElse(ResponseEntity.notFound().build());
    }
}

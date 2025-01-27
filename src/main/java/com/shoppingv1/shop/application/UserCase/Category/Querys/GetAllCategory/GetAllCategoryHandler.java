package com.shoppingv1.shop.application.UserCase.Category.Querys.GetAllCategory;

import java.util.List;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shoppingv1.shop.application.Mappers.interfaces.CategoryMapper;
import com.shoppingv1.shop.application.UserCase.Query;
import com.shoppingv1.shop.application.UserCase.Category.Dtos.CategoryDto;
import com.shoppingv1.shop.core.Ports.services.CategoryService;
import com.shoppingv1.shop.core.domain.Category;

@Service
public class GetAllCategoryHandler implements Query<Void, List<CategoryDto>> {

    private final CategoryService categoryRepository;
    private final CategoryMapper categoryMapper;
    
    @Autowired
    public GetAllCategoryHandler(CategoryService categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public ResponseEntity<List<CategoryDto>> handle(Void request) {
       
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = categories.stream().map(categoryMapper::toCategoryDto).collect(Collectors.toList());

        return  ResponseEntity.ok(categoryDtos);
    }

}

package com.shoppingv1.shop.application.Mappers.interfaces;

import org.mapstruct.*;

import com.shoppingv1.shop.application.UserCase.Category.Commands.CreateCategory.CreateCategoryCommand;
import com.shoppingv1.shop.application.UserCase.Category.Dtos.CategoryDto;
import com.shoppingv1.shop.core.domain.Category;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
 
    CategoryDto toCategoryDto(Category category);
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryDto categoryDto);
    @Mapping(target = "products", ignore = true)
    Category toCategory(CreateCategoryCommand createCategoryCommand);
}

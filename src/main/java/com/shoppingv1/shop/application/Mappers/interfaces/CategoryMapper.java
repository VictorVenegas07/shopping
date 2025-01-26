package com.shoppingv1.shop.application.Mappers.interfaces;

import org.mapstruct.Mapper;

import com.shoppingv1.shop.application.UserCase.Category.Dtos.CategortyDto;
import com.shoppingv1.shop.core.domain.Category;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
 
    CategortyDto toCategoryDto(Category category);
    Category toCategory(CategortyDto categoryDto);
}

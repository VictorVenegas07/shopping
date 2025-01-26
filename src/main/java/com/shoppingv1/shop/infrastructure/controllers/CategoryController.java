package com.shoppingv1.shop.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingv1.shop.application.UserCase.Category.Dtos.CategortyDto;
import com.shoppingv1.shop.application.UserCase.Category.Querys.GetAllCategory.GetAllCategoryHandler;



@RestController
@RequestMapping("/category")
public class CategoryController {

    private final GetAllCategoryHandler getAllCategoryHandler;
    @Autowired
    public CategoryController(GetAllCategoryHandler getAllCategoryHandler) {
        this.getAllCategoryHandler = getAllCategoryHandler;
    }
   
    @GetMapping
    public ResponseEntity<List<CategortyDto>> getMyDomains(){
        return getAllCategoryHandler.handle(null);
    }   
}

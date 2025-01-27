package com.shoppingv1.shop.infrastructure.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingv1.shop.application.UserCase.Category.Commands.CreateCategory.CreateCategoryCommand;
import com.shoppingv1.shop.application.UserCase.Category.Commands.CreateCategory.CreateCategoryHandler;
import com.shoppingv1.shop.application.UserCase.Category.Commands.DeleteCategory.DeleteCategoryHandler;
import com.shoppingv1.shop.application.UserCase.Category.Commands.UpdateCategory.UpdateCategoryCommand;
import com.shoppingv1.shop.application.UserCase.Category.Commands.UpdateCategory.UpdateCategoryHandler;
import com.shoppingv1.shop.application.UserCase.Category.Dtos.CategoryDto;
import com.shoppingv1.shop.application.UserCase.Category.Querys.GetAllCategory.GetAllCategoryHandler;
import com.shoppingv1.shop.application.UserCase.Category.Querys.GetCategoryById.GetCategoryByIdHandler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final GetAllCategoryHandler getAllCategoryHandler;
    private final CreateCategoryHandler createCategoryHandler;
    private final UpdateCategoryHandler updateCategoryHandler;
    private final DeleteCategoryHandler deleteCategoryHandler;
    private final GetCategoryByIdHandler getCategoryByIdHandler;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getMyDomains() {
        return getAllCategoryHandler.handle(null);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CreateCategoryCommand Command) {
        return createCategoryHandler.handle(Command);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        return getCategoryByIdHandler.handle(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody UpdateCategoryCommand command) {
        command.setId(id);
        return updateCategoryHandler.handle(command);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        return deleteCategoryHandler.handle(id);
    }

}

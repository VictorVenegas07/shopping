package com.shoppingv1.shop.application.UserCase.Category.Commands.CreateCategory;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@Data
public class CreateCategoryCommand {

    @NotNull
    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String name;
    @NotNull
    @Size(min = 5)
    private String description;

    public CreateCategoryCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
}

package com.shoppingv1.shop.application.UserCase.Category.Commands.UpdateCategory;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
public class UpdateCategoryCommand {

    @NotNull(message = "El ID no puede ser nulo")
    private Long id;

    @NotNull
    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String name;

    @NotNull
    @Size(min = 5, message = "La descripción debe tener al menos 5 caracteres")
    private String description;

    public UpdateCategoryCommand(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}

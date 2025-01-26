package com.shoppingv1.shop.core.domain;

import java.util.*;

import com.shoppingv1.shop.core.domain.Base.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tag extends BaseEntity  {
    
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "tags")
    @Builder.Default
    private List<Product> products = new ArrayList<>();

    // Getters y Setters
}

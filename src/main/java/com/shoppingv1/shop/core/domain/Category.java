package com.shoppingv1.shop.core.domain;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shoppingv1.shop.core.domain.Base.BaseEntity;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {
    
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    
}

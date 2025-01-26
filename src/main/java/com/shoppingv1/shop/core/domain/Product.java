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
public class Product extends BaseEntity {

    
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    // Relación Uno a Uno con ProductDetail
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id", referencedColumnName = "id")
    @JsonIgnore
    private ProductDetail detail;

    // Relación Muchos a Uno con Category
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    // Relación Muchos a Muchos con Tag
    @ManyToMany
    @JoinTable(
        name = "product_tags",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )

    @Builder.Default
    private List<Tag> tags = new ArrayList<>();

    // Getters y Setters
}

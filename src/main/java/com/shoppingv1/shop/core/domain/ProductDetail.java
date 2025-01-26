package com.shoppingv1.shop.core.domain;

import com.shoppingv1.shop.core.domain.Base.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail extends BaseEntity  {
    
    @Column(name = "description")
    private String description;
    @Column(name = "manufacturer")
    private String manufacturer;

    // Relación Uno a Uno inversa con Product
    @OneToOne(mappedBy = "detail")
    private Product product;

}
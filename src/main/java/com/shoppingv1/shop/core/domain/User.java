package com.shoppingv1.shop.core.domain;



import com.shoppingv1.shop.core.domain.Base.BaseEntity;

import lombok.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
 
    
    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

}

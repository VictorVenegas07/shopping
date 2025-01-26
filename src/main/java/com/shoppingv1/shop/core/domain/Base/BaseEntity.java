package com.shoppingv1.shop.core.domain.Base;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.*;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        // Declarar el identificador abstracto
        // public abstract Long getId();
        // public abstract void setId(Long id);
    
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    
        @PrePersist
        protected void onCreate() {
            this.createdAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
        }
    
        @PreUpdate
        protected void onUpdate() {
            this.updatedAt = LocalDateTime.now();
        }
}

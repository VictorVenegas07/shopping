package com.shoppingv1.shop.core.services;


import org.springframework.stereotype.Service;

import com.shoppingv1.shop.core.Ports.Repositories.CategoryDomainRepository;
import com.shoppingv1.shop.core.Ports.services.CategoryService;
import com.shoppingv1.shop.core.domain.Category;
import com.shoppingv1.shop.infrastructure.adapters.AbstractBaseRepositoryImpl;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl extends AbstractBaseRepositoryImpl<Category,Long> implements CategoryService{

    private CategoryDomainRepository categoryDomainRepository;
    public CategoryServiceImpl(CategoryDomainRepository categoryDomainRepository) {
        super(categoryDomainRepository);
        this.categoryDomainRepository = categoryDomainRepository;
    }

    @Override
    public boolean existsById(Long entityId) {
        return categoryDomainRepository.existsById(entityId);
    }

}

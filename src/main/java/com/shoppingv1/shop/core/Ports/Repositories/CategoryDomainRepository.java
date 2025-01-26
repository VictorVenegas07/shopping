package com.shoppingv1.shop.core.Ports.Repositories;

import org.springframework.stereotype.Repository;

import com.shoppingv1.shop.core.Ports.AbstractBaseRepository;
import com.shoppingv1.shop.core.domain.Category;

@Repository
public interface CategoryDomainRepository extends AbstractBaseRepository<Category, Long> {

}

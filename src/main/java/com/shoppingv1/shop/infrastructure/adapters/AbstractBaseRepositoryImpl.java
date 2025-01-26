package com.shoppingv1.shop.infrastructure.adapters;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingv1.shop.core.Ports.AbstractBaseRepository;
import com.shoppingv1.shop.core.domain.Base.BaseEntity;
import com.shoppingv1.shop.core.services.AbstractBaseService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public abstract class AbstractBaseRepositoryImpl<T extends BaseEntity, ID extends Serializable>
        implements AbstractBaseService<T, ID>{
    
    private AbstractBaseRepository<T, ID> abstractBaseRepository;
    
    @Autowired
    public AbstractBaseRepositoryImpl(AbstractBaseRepository<T, ID> abstractBaseRepository) {
        this.abstractBaseRepository = abstractBaseRepository;
    }
    
    @Override
    public T save(T entity) {
        return (T) abstractBaseRepository.save(entity);
    }

    @Override
    public List<T> findAll() {
        return abstractBaseRepository.findAll();
    }

    @Override
    public Optional<T> findById(ID entityId) {
        return abstractBaseRepository.findById(entityId);
    }

    @Override
    public T update(T entity) {
        return (T) abstractBaseRepository.save(entity);
    }

    @Override
    public T updateById(T entity, ID entityId) {
        Optional<T> optional = abstractBaseRepository.findById(entityId);
        if(optional.isPresent()){
            return (T) abstractBaseRepository.save(entity);
        }else{
            return null;
        }
    }

    @Override
    public void delete(T entity) {
        abstractBaseRepository.delete(entity);
    }

    @Override
    public void deleteById(ID entityId) {
        abstractBaseRepository.deleteById(entityId);
    }

}

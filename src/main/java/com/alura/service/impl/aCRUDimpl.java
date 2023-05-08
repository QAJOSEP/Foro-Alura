package com.alura.service.impl;

import java.util.List;

import com.alura.exceptions.ModelNotFoundException;
import com.alura.repository.IGenericRepo;
import com.alura.service.ICRUD;

public abstract class aCRUDimpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> repo();

    protected final String msg = "ID WAS NOT FOUND";
    
    @Override
    public List<T> findAll() {
        
        return repo().findAll();
    }

    @Override
    public T findById(ID id) {
        
        return repo().findById(id).orElseThrow(() -> new ModelNotFoundException(msg + id));
    }

    @Override
    public T save(T t) {
        
        return repo().save(t);
    }

    @Override
    public T update(T t, ID id) {
        repo().findById(id).orElseThrow(() -> new ModelNotFoundException(msg + id));
        return repo().save(t);
    }
    
    @Override
    public void delete(ID id) {
        repo().findById(id).orElseThrow(() -> new ModelNotFoundException(msg + id));
        repo().deleteById(id);

    }
}

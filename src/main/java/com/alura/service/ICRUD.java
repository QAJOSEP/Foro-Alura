package com.alura.service;

import java.util.List;

public interface ICRUD<T,ID> {
    
    List<T> findAll();
    T findById(ID id);

    T save(T t);

    T update( T t, ID id);

    void delete(ID id);
}

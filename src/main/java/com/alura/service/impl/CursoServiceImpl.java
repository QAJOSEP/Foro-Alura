package com.alura.service.impl;

import org.springframework.stereotype.Service;

import com.alura.model.Curso;
import com.alura.repository.ICursoRepo;
import com.alura.repository.IGenericRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl extends aCRUDimpl<Curso,Long> {
    
    
    private final ICursoRepo repo;

    @Override
    protected IGenericRepo<Curso, Long> repo() {
        
        return repo;
    }
    
}

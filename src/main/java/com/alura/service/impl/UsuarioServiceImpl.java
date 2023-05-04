package com.alura.service.impl;

import org.springframework.stereotype.Service;

import com.alura.model.Usuario;
import com.alura.repository.IGenericRepo;
import com.alura.repository.IUsuarioRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends aCRUDimpl<Usuario,Long> {
    
    
    private final IUsuarioRepo repo;

    @Override
    protected IGenericRepo<Usuario, Long> repo() {
        
        return repo;
    }
    
}

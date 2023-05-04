package com.alura.service.impl;

import org.springframework.stereotype.Service;

import com.alura.model.Topico;
import com.alura.repository.IGenericRepo;
import com.alura.repository.ITopicoRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TopicoServiceImpl extends aCRUDimpl<Topico,Long> {
    
    
    private final ITopicoRepo repo;

    @Override
    protected IGenericRepo<Topico, Long> repo() {
        
        return repo;
    }
    
}

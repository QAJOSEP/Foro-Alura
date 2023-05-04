package com.alura.service.impl;

import org.springframework.stereotype.Service;

import com.alura.model.Respuesta;
import com.alura.repository.IGenericRepo;
import com.alura.repository.IRespuestaRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RespuestaServiceImpl extends aCRUDimpl<Respuesta,Long> {
    
    
    private final IRespuestaRepo repo;

    @Override
    protected IGenericRepo<Respuesta, Long> repo() {
        
        return repo;
    }
    
}

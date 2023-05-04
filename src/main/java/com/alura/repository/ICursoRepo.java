package com.alura.repository;

import org.springframework.stereotype.Repository;

import com.alura.model.Curso;


@Repository
public interface ICursoRepo extends IGenericRepo<Curso,Long>{
    
}

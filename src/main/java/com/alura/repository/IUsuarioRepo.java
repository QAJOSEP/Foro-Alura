package com.alura.repository;

import org.springframework.stereotype.Repository;

import com.alura.model.Usuario;


@Repository
public interface IUsuarioRepo extends IGenericRepo<Usuario,Long>{

    Usuario findOneByUsername(String username);
    
}

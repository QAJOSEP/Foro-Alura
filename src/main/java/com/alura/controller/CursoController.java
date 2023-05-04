package com.alura.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.model.Curso;
import com.alura.service.impl.CursoServiceImpl;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {
    
    private final CursoServiceImpl ser;

    @GetMapping
    public ResponseEntity<List<Curso>> listarTodo() {
        List<Curso> res = ser.findAll();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Curso> listar(@PathVariable Long id) {
        Curso res = ser.findById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Curso> add(@RequestBody Curso entity) {
        Curso res = ser.save(entity);
        
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso entity) {
        entity.setId(id);
        Curso res = ser.save(entity);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        ser.delete(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}

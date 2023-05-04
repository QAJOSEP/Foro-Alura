package com.alura.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.model.Respuesta;
import com.alura.service.impl.RespuestaServiceImpl;

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
@RequestMapping("/respuestas")
@RequiredArgsConstructor
public class RespuestaController {
    
    private final RespuestaServiceImpl ser;

    @GetMapping
    public ResponseEntity<List<Respuesta>> listarTodo() {
        List<Respuesta> res = ser.findAll();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Respuesta> listar(@PathVariable Long id) {
        Respuesta res = ser.findById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Respuesta> add(@RequestBody Respuesta entity) {
        Respuesta res = ser.save(entity);
        
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity<Respuesta> update(@PathVariable Long id, @RequestBody Respuesta entity) {
        entity.setId(id);
        Respuesta res = ser.save(entity);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        ser.delete(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}

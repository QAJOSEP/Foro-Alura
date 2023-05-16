package com.alura.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alura.dto.CursoDTO;
import com.alura.model.Curso;
import com.alura.service.impl.CursoServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;





@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {
    
    private final CursoServiceImpl ser;
    private final ModelMapper mapper;

    @GetMapping(value="/hateoas/{id}")
    public EntityModel<CursoDTO> findByHateoas(@PathVariable Long id) {
        EntityModel<CursoDTO> resource = EntityModel.of(this.convertToDto(ser.findById(id)));
        
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).findByHateoas(id));
        WebMvcLinkBuilder link2 = linkTo(methodOn(RespuestaController.class).listarTodo());
        resource.add(link1.withRel("curso-info1"));
        resource.add(link2.withRel("curso-info1"));

        return resource;
    }
    
    @GetMapping
    public ResponseEntity<List<CursoDTO>> listarTodo() {
        List<CursoDTO> list = ser.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<CursoDTO> listar(@PathVariable Long id) {
        CursoDTO dto = this.convertToDto(ser.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Void> add(@Valid @RequestBody CursoDTO dto) {
        Curso obj = ser.save(this.convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCurso()).toUri();
        return ResponseEntity.created(location).build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> update(@Valid @PathVariable Long id, @RequestBody CursoDTO dto) {
        dto.setIdCurso(id);
        Curso object = ser.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDto(object), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        ser.delete(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    private CursoDTO convertToDto(Curso obj){
        return mapper.map(obj, CursoDTO.class);
    }
    private Curso convertToEntity(CursoDTO dto){
        return mapper.map(dto, Curso.class);
    }
}

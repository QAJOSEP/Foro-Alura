package com.alura.dto;

import java.util.List;

import com.alura.model.Topico;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
    
    private Long idCurso;
    
    @NotNull
    @Size(min = 3, message = "Se requiere el nombre")
	private String nombre;

	private String categoria;
    
    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos;

}

package com.alura.dto;

import java.util.ArrayList;
import java.util.List;

import com.alura.model.Topico;

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
    
    private List<Topico> topicos = new ArrayList<>();

}

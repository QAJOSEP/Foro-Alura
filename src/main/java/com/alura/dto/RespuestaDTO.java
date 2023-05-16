package com.alura.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.alura.model.Topico;
import com.alura.model.Usuario;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaDTO {
    
    private Long idRespuesta;
	private String mensaje;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_topico")
    private Topico topico;

    private LocalDateTime fechaCreacion;
    @OneToMany(mappedBy = "respuesta")
    private List<Usuario> autor;
	private Boolean solucion = false;
}

package com.alura.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.alura.model.Curso;
import com.alura.model.Respuesta;
import com.alura.model.StatusTopico;
import com.alura.model.Usuario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicoDTO {
    
    private Long idTopico;
	private String titulo;
	private String mensaje;
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	private StatusTopico status = StatusTopico.NO_RESPONDIDO;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario",foreignKey = @ForeignKey(name="FK_TOPICO_USUARIO"))
	private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso", foreignKey = @ForeignKey(name="FK_TOPICO_CURSO"))
	private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Respuesta> respuestas = new ArrayList<>();

}

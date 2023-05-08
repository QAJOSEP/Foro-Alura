package com.alura.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Topico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public Topico(String titulo, String mensaje, Curso curso) {
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTopico == null) ? 0 : idTopico.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topico other = (Topico) obj;
		if (idTopico == null) {
			if (other.idTopico != null)
				return false;
		} else if (!idTopico.equals(other.idTopico))
			return false;
		return true;
	}

	public Long getId() {
		return idTopico;
	}

	public void setId(Long idTopico) {
		this.idTopico = idTopico;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime getfechaCreacion() {
		return fechaCreacion;
	}

	public void setfechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public void setStatus(StatusTopico status) {
		this.status = status;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

}

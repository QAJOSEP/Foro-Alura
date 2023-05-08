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
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRespuesta;
	private String mensaje;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_topico", foreignKey = @ForeignKey(name = "FK_RESPUESTA_TOPICO"))
	private Topico topico;

	private LocalDateTime fechaCreacion = LocalDateTime.now();

	@OneToMany(mappedBy = "respuesta",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Usuario> autor = new ArrayList<>();
	private Boolean solucion = false;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRespuesta == null) ? 0 : idRespuesta.hashCode());
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
		Respuesta other = (Respuesta) obj;
		if (idRespuesta == null) {
			if (other.idRespuesta != null)
				return false;
		} else if (!idRespuesta.equals(other.idRespuesta))
			return false;
		return true;
	}

	public Long getId() {
		return idRespuesta;
	}

	public void setId(Long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Topico getTopico() {
		return topico;
	}

	public void setTopico(Topico topico) {
		this.topico = topico;
	}

	public LocalDateTime getfechaCreacion() {
		return fechaCreacion;
	}

	public void setfechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<Usuario> getAutor() {
		return autor;
	}

	public void setAutor(List<Usuario> autor) {
		this.autor = autor;
	}

	public Boolean getSolucion() {
		return solucion;
	}

	public void setSolucion(Boolean solucion) {
		this.solucion = solucion;
	}

}

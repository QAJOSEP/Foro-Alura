package com.alura.dto;

import java.util.List;

import com.alura.model.Respuesta;
import com.alura.model.Role;

import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    
    private Long id;

	private String nombre;
	private String email;
	private String contrasena;

	private boolean enabled;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usario_role", joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole"))
	private List<Role> role;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_respuesta", foreignKey = @ForeignKey(name="FK_USUARIO_RESPUESTA"))
	private Respuesta respuesta;

}

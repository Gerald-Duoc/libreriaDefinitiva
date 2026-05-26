package registro.usuario.model;

import registro.usuario.model.TipoUsuario;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Usuarios")

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	@NotBlank(message = "nombre completo destino no puede estar en blanco")
	@Size(min = 3, max = 60, message = "nombre completo debe ser entre 3 y 60 caracteres")
	@Column(nullable = false)
	private String nombreCompleto;

	@NotBlank(message = "email destino no puede estar en blanco")
	@Size(min = 6, max = 80, message = "email debe ser entre 3 y 80 caracteres")
	@Column(nullable = false)
	private String email;

	@NotBlank(message = "password destino no puede estar en blanco")
	@Size(min = 8, max = 80, message = "password debe ser entre 8 y 80 caracteres")
	@Column(nullable = false)
	private String password;

	@ManyToOne
	@JoinColumn(name = "id_tipo_usuario")
	private TipoUsuario tipoUsuario;

	private Date fechaRegistro;

	private boolean activo;

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		tipoUsuario = tipoUsuario;
	}

	public void setFechaRegistro(Date fecha) {
		fechaRegistro = fecha;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}

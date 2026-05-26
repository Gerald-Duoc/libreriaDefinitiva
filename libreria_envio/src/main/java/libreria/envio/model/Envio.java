package libreria.envio.model;

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
@Table(name = "envio")

public class Envio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date fechaCreacion;
	private Date fechaLlegadaProgramada;
	private Date fechaEnvio;
	private Date fechaLlegada;

	@ManyToOne
	@JoinColumn(name = "id_estado_envio")
	private EstadoEnvio estadoEnvio;

	@ManyToOne
	@JoinColumn(name = "id_Tipo_envio")
	private TipoEnvio tipoEnvio;
	// id sede con producto

	@NotBlank(message = "direccion destino no puede estar en blanco")
	@Size(min = 3, max = 80, message = "direccion destino debe ser entre 3 y 80 caracteres")
	@Column(nullable = false)
	private String direccionDestino;

	@NotBlank(message = "notas no puede estar en blanco")
	@Size(min = 3, max = 80, message = "notas debe ser entre 3 y 80 caracteres")
	@Column(nullable = false)
	private String notas;

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaLlegadaProgramada() {
		return fechaLlegadaProgramada;
	}

	public void setFechaLlegadaProgramada(Date fechaLlegadaProgramada) {
		this.fechaLlegadaProgramada = fechaLlegadaProgramada;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public String getDireccionDestino() {
		return direccionDestino;
	}

	public void setDireccionDestino(String direccionDestino) {
		this.direccionDestino = direccionDestino;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

}

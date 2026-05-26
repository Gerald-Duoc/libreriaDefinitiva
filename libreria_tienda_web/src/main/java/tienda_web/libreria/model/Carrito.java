package tienda_web.libreria.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Carritos")
public class Carrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// private Long idUsuario;

	private Date fechaCreacion;

	// private List<ItemProducto> productos;

	private Date UltimaActualizacion;

	@ManyToOne
	@JoinColumn(name = "id_estado_carrito")
	private EstadoCarrito estadoCarrito;

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getUltimaActualizacion() {
		return UltimaActualizacion;
	}

	public void setUltimaActualizacion(Date ultimaActualizacion) {
		UltimaActualizacion = ultimaActualizacion;
	}

	public EstadoCarrito getEstadoCarrito() {
		return estadoCarrito;
	}

	public void setEstadoCarrito(EstadoCarrito estadoCarrito) {
		this.estadoCarrito = estadoCarrito;
	}

}

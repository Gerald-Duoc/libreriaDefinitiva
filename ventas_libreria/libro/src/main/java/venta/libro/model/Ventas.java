package venta.libro.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ventas")
public class Ventas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double subtotal;

	private Double descuentoTotal;

	@Column(nullable = false)
	private Double total;

	@ManyToOne
	@JoinColumn(name = "id_medio_pago")
	private MedioPago medioPago;

	@ManyToOne
	@JoinColumn(name = "id_estado_venta")
	private EstadoVenta estadoVenta;

	private Double vuelto;

	private Long idCliente;

	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<OrdenVenta> ordenventas;
}

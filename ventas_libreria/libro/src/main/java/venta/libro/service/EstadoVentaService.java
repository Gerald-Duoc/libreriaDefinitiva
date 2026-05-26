package venta.libro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import venta.libro.model.EstadoVenta;
import venta.libro.repository.EstadoVentaRepository;

@Service
public class EstadoVentaService {
	@Autowired
	public EstadoVentaRepository estadoVentaRepository;

	public List<EstadoVenta> getLista() {
		return estadoVentaRepository.findAll();
	}

	public EstadoVenta postEstadoVenta(EstadoVenta estadoVenta) {
		return estadoVentaRepository.save(estadoVenta);
	}

	public EstadoVenta modificarOrden(Long id, EstadoVenta estadoVenta) {
		EstadoVenta estadoVentaCambio = estadoVentaRepository.findById(id).orElse(null);
		if (estadoVentaCambio != null) {
			estadoVentaCambio.setNombre(estadoVenta.getNombre());
			estadoVentaRepository.save(estadoVentaCambio);
		}
		return null;
	}

	public void deleteEstadoVenta(Long id) {
		estadoVentaRepository.deleteById(id);
	}
}

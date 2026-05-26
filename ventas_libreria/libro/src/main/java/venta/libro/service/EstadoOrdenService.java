package venta.libro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import venta.libro.model.EstadoOrden;
import venta.libro.repository.EstadoOrdenRepository;

@Service
public class EstadoOrdenService {
	@Autowired
	public EstadoOrdenRepository estadoOrdenRepository;

	public List<EstadoOrden> getLista() {
		return estadoOrdenRepository.findAll();
	}

	public EstadoOrden postEstadoOrden(EstadoOrden estadoOrden) {
		return estadoOrdenRepository.save(estadoOrden);
	}

	public void deleteEstadoOrden(Long id) {
		estadoOrdenRepository.deleteById(id);
	}

	public EstadoOrden modificarOrden(Long id, EstadoOrden estadoOrden) {
		EstadoOrden estadoOrdenCambio = estadoOrdenRepository.findById(id).orElse(null);
		if (estadoOrdenCambio != null) {
			estadoOrdenCambio.setNombre(estadoOrden.getNombre());
			return estadoOrdenRepository.save(estadoOrdenCambio);
		}
		return null;
	}
}

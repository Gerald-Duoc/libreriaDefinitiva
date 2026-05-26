package tienda_web.libreria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienda_web.libreria.model.EstadoCarrito;
import tienda_web.libreria.repository.EstadoCarritoRepository;

@Service
public class EstadoCarritoService {
	@Autowired
	private EstadoCarritoRepository estadoCarritoRepository;

	public List<EstadoCarrito> getEstados() {
		return estadoCarritoRepository.findAll();
	}

	public EstadoCarrito postEstadoCarrito(EstadoCarrito estadoCarrito) {
		return estadoCarritoRepository.save(estadoCarrito);
	}

	public void deleteById(Long id) {
		estadoCarritoRepository.deleteById(id);
	}

	public EstadoCarrito modificarEstado(Long id, EstadoCarrito estadoCarrito) {
		EstadoCarrito estadoModificado = estadoCarritoRepository.findById(id).orElse(null);
		if (estadoModificado != null) {
			estadoModificado.setNombre(estadoCarrito.getNombre());
			return estadoCarritoRepository.save(estadoModificado);
		}
		return null;
	}

}

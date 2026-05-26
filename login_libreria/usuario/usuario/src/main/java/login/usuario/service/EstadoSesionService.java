package login.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import login.usuario.model.EstadoSesion;
import login.usuario.repository.EstadoSesionRepository;

@Service
public class EstadoSesionService {
	@Autowired
	public EstadoSesionRepository estadoSesionRepository;

	public List<EstadoSesion> getEstados() {
		return estadoSesionRepository.findAll();
	}

	public EstadoSesion postEstadoSesion(EstadoSesion estadoSesion) {
		return estadoSesionRepository.save(estadoSesion);
	}

	public void deleteEstadoSesion(Long id) {
		estadoSesionRepository.deleteById(id);
	}

	public EstadoSesion modificarEstadoSesion(Long id, EstadoSesion estadoSesion) {
		EstadoSesion estadoCambiar = estadoSesionRepository.findById(id).orElse(null);
		if (estadoCambiar != null) {
			estadoCambiar.setNombre(estadoSesion.getNombre());
			return estadoSesionRepository.save(estadoCambiar);
		}
		return null;

	}

	public EstadoSesion getEstadoSesionId(@Valid Long id) {
		return estadoSesionRepository.findById(id).orElse(null);
	}

}


package libreria.envio.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import libreria.envio.model.Envio;
import libreria.envio.model.EstadoEnvio;
import libreria.envio.repository.EstadoEnvioRepository;

@Service
public class EstadoEnvioService {
	@Autowired
	private EstadoEnvioRepository estadoEnvioRepository;

	public List<EstadoEnvio> getEstadosEnvio() {
		return estadoEnvioRepository.findAll();
	}

	public EstadoEnvio postEstadoEnvio(EstadoEnvio estadoEnvio) {
		return estadoEnvioRepository.save(estadoEnvio);
	}

	public EstadoEnvio modificarEstadoEnvio(Long id, EstadoEnvio estadoEnvio) {
		EstadoEnvio estadoEnvioCambiado = estadoEnvioRepository.findById(id).orElse(null);
		if (estadoEnvioCambiado != null) {
			estadoEnvioCambiado.setNombre(estadoEnvio.getNombre());
			return estadoEnvioRepository.save(estadoEnvioCambiado);
		}
		return null;
	}

	public void deleteEstadoEnvio(Long id) {
		estadoEnvioRepository.deleteById(id);
	}
}

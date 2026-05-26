package libreria.envio.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import libreria.envio.model.Envio;
import libreria.envio.repository.EnvioRepository;

@Service
public class EnvioService {
	@Autowired
	private EnvioRepository envioRepository;

	public List<Envio> getEnvios() {
		return envioRepository.findAll();
	}

	public Envio postEnvio(Envio envio) {
		envio.setFechaCreacion(new Date());
		return envioRepository.save(envio);
	}

	public void deleteEnvio(Long id) {
		envioRepository.deleteById(id);
	}

	public Envio modificarEnvio(Long id, Envio envio) {
		Envio envioCambio = envioRepository.findById(id).orElse(null);
		if (envioCambio != null) {

			envioCambio.setNotas(envio.getNotas());
			envioCambio.setDireccionDestino(envio.getDireccionDestino());
			envioCambio.setFechaLlegadaProgramada(envio.getFechaLlegadaProgramada());
			envioCambio.setFechaEnvio(envio.getFechaEnvio());
			envioCambio.setFechaLlegada(envio.getFechaLlegada());

			return envioRepository.save(envioCambio);
		}
		return null;
	}
}

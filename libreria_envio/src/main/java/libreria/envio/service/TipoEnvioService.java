package libreria.envio.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import libreria.envio.model.TipoEnvio;
import libreria.envio.repository.TipoEnvioRepository;

@Service
public class TipoEnvioService {
	@Autowired
	private TipoEnvioRepository tipoEnvioRepository;

	public List<TipoEnvio> getTipoEnvio() {
		return tipoEnvioRepository.findAll();
	}

	public TipoEnvio postTipoEnvio(TipoEnvio tipoEnvio) {
		return tipoEnvioRepository.save(tipoEnvio);
	}

	public void deleteTipoEnvio(Long id) {
		tipoEnvioRepository.deleteById(id);
	}

	public TipoEnvio modificarTipoEnvio(Long id, TipoEnvio tipoEnvio) {
		TipoEnvio tipoEnvioCambiado = tipoEnvioRepository.findById(id).orElse(null);
		if (tipoEnvioCambiado != null) {
			tipoEnvioCambiado.setNombre(tipoEnvio.getNombre());
			return tipoEnvioRepository.save(tipoEnvioCambiado);
		}
		return null;
	}

}

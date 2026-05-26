package registro.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import registro.usuario.model.TipoUsuario;
import registro.usuario.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;

	public TipoUsuario buscarId(@Valid Long id) {
		return tipoUsuarioRepository.findById(id).orElse(null);
	}

	public List<TipoUsuario> findAll() {
		return tipoUsuarioRepository.findAll();
	}

	public TipoUsuario postTipoUsuario(@Valid TipoUsuario tipoUsuario) {
		return tipoUsuarioRepository.save(tipoUsuario);
	}

	public TipoUsuario modificarUsuario(@Valid Long id, TipoUsuario tipoUsuario) {
		TipoUsuario tipoUsuarioCambio = tipoUsuarioRepository.findById(id).orElse(null);
		if (tipoUsuarioCambio != null) {
			tipoUsuarioCambio.setNombre(tipoUsuario.getNombre());
			return tipoUsuarioRepository.save(tipoUsuarioCambio);

		}
		return null;

	}

	public void deleteTipoUsuario(Long id) {
		tipoUsuarioRepository.deleteById(id);
	}
}

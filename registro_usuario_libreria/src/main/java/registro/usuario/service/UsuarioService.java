package registro.usuario.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import registro.usuario.model.TipoUsuario;
import registro.usuario.model.Usuario;
import registro.usuario.repository.TipoUsuarioRepository;
import registro.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	public UsuarioRepository usuarioRepository;
	@Autowired
	public TipoUsuarioRepository tipoUsuarioRepository;

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	/*
	 * public Usuario agregarUsuario(Usuario usuario) {
	 * Long idTipo = usuario.getIdTipoUsuario();
	 * if (tipoUsuarioRepository.findById(idTipo) == null) {
	 * usuario.setTipoUsuario(null);
	 * } else {
	 * TipoUsuario tipo = tipoUsuarioRepository.findById(idTipo).orElse(null);
	 * usuario.setTipoUsuario(tipo.getNombre());
	 * }
	 * 
	 * return usuarioRepository.save(usuario);
	 * }
	 */

	public Usuario agregarUsuario(@Valid Usuario usuario) {
		usuario.setFechaRegistro(new Date());
		return usuarioRepository.save(usuario);
	}

	public Optional<Usuario> getUsuarioId(@Valid Long id) {
		return usuarioRepository.findById(id);
	}

	public void deleteUsuario(@Valid Long id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario modificarUsuario(@Valid Long id, Usuario usuario) {
		Usuario usuarioCambiado = usuarioRepository.findById(id).orElse(null);
		if (usuarioCambiado != null) {
			usuarioCambiado.setNombreCompleto(usuario.getNombreCompleto());
			usuarioCambiado.setEmail(usuario.getEmail());
			usuarioCambiado.setPassword(usuario.getPassword());
			usuarioCambiado.setTipoUsuario(usuario.getTipoUsuario());
			usuarioCambiado.setActivo(usuario.isActivo());
			return usuarioRepository.save(usuarioCambiado);

		}
		return null;
	}

}

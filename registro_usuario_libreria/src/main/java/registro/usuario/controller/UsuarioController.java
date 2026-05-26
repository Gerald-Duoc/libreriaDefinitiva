package registro.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import registro.usuario.service.UsuarioService;
import registro.usuario.model.TipoUsuario;
import registro.usuario.model.Usuario;

@RestController
@RequestMapping("api/v1/usuarios")

public class UsuarioController {
	@Autowired
	public UsuarioService usuarioService;

	@GetMapping
	public List<Usuario> getusuarios() {
		return usuarioService.listarUsuarios();
	}

	@GetMapping("buscar/{id}")
	public ResponseEntity getusuariosIdLocal(@Valid @PathVariable Long id) {
		Usuario usuario = usuarioService.getUsuarioId(id).orElse(null);

		if (usuario == null) {
			return ResponseEntity
					.status(404)
					.body("Usuario no encontrado");

		}
		return ResponseEntity.ok(usuario);

	}

	@PostMapping("postusuario")
	public ResponseEntity<String> postUsuario(@Valid @RequestBody Usuario usuario) {
		try {
			usuarioService.agregarUsuario(usuario);
			return ResponseEntity.ok("Usuario agregado exitosamente");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("datos erroneos/incompletos" + e.getMessage());
		}
	}

	@GetMapping("buscarid/{id}")
	public ResponseEntity<Usuario> getUsuarioId(@Valid @PathVariable Long id) {
		Usuario buscado = usuarioService.getUsuarioId(id).orElse(null);

		if (buscado == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(buscado, HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteId(@Valid @PathVariable Long id) {
		Usuario usuario = usuarioService.getUsuarioId(id).orElse(null);
		if (usuario == null) {
			return ResponseEntity
					.status(404)
					.body("Usuario no encontrado");

		}
		usuarioService.deleteUsuario(id);
		return ResponseEntity.ok("Usuario eliminado correctamente");

	}

	@PutMapping("modificar/{id}")
	public ResponseEntity modificarUsuario(@Valid @PathVariable Long id, @RequestBody Usuario usuario) {
		try {
			usuarioService.modificarUsuario(id, usuario);
			return ResponseEntity.ok(usuario);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("datos erroneos/incompletos" + e.getMessage());
		}
	}

}

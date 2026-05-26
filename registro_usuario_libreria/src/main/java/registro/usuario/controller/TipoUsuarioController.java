package registro.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import registro.usuario.model.TipoUsuario;
import registro.usuario.service.TipoUsuarioService;

@RestController
@RequestMapping("api/v1/tipoUsuario")
public class TipoUsuarioController {
	@Autowired
	public TipoUsuarioService tipoUsuarioService;

	@GetMapping("{id}")
	public ResponseEntity getById(@PathVariable Long id) {
		TipoUsuario tipoUsuario = tipoUsuarioService.buscarId(id);
		if (tipoUsuario == null) {
			return ResponseEntity
					.status(404)
					.body("Recursos no encontrados");

		}
		return ResponseEntity.ok(tipoUsuario);
	}

	@PostMapping
	public ResponseEntity<String> postTipoUsuario(@Valid @RequestBody TipoUsuario tipoUsuario) {
		try {
			tipoUsuarioService.postTipoUsuario(tipoUsuario);
			return ResponseEntity.ok("Tipo Usuario agregado exitosamente");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("datos erroneos/incompletos" + e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity getEnvios() {
		List<TipoUsuario> lista = tipoUsuarioService.findAll();

		if (lista.isEmpty()) {
			return ResponseEntity
					.status(404)
					.body("tipo usuario no encontrado");

		}
		return ResponseEntity.ok(lista);
	}

	@PutMapping("modificar/{id}")
	public ResponseEntity modificarTipoUsuario(@Valid @PathVariable Long id, @RequestBody TipoUsuario tipoUsuario) {
		TipoUsuario tipoUsuarioBuscado = tipoUsuarioService.buscarId(id);
		if (tipoUsuarioBuscado == null) {
			return ResponseEntity
					.status(404)
					.body("tipo usuario no encontrado");

		}
		tipoUsuarioService.modificarUsuario(id, tipoUsuario);
		return ResponseEntity.ok(tipoUsuarioBuscado);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteId(@PathVariable Long id) {
		TipoUsuario tipoUsuario = tipoUsuarioService.buscarId(id);
		if (tipoUsuario == null) {
			return ResponseEntity
					.status(404)
					.body("tipo usuario no encontrado");

		}
		tipoUsuarioService.deleteTipoUsuario(id);
		return ResponseEntity.ok("tipo usuario eliminado correctamente");

	}

}

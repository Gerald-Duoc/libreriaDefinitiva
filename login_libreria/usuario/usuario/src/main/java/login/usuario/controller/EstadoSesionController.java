package login.usuario.controller;

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
import login.usuario.model.EstadoSesion;
import login.usuario.service.EstadoSesionService;

@RestController
@RequestMapping("api/v1/EstadoSesion")
public class EstadoSesionController {
	@Autowired
	public EstadoSesionService estadoSesionService;

	@GetMapping
	public List<EstadoSesion> getEstados() {
		return estadoSesionService.getEstados();
	}

	@GetMapping("buscarid/{id}")
	public ResponseEntity getEstadoSesionId(@Valid @PathVariable Long id) {
		EstadoSesion estadoSesion = estadoSesionService.getEstadoSesionId(id);
		if (estadoSesion == null) {
			return ResponseEntity
					.status(404)
					.body("tipo usuario no encontrado");

		}
		return ResponseEntity.ok(estadoSesion);
	}

	@PostMapping
	public ResponseEntity<String> postEnvio(@Valid @RequestBody EstadoSesion estadoSesion) {
		try {
			estadoSesionService.postEstadoSesion(estadoSesion);
			return ResponseEntity.ok("Estado sesion agregado exitosamente");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("datos erroneos/incompletos" + e.getMessage());
		}
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleEstadoSesion(@Valid @PathVariable Long id) {
		EstadoSesion estadoSesion = estadoSesionService.getEstadoSesionId(id);
		if (estadoSesion == null) {
			return ResponseEntity
					.status(404)
					.body("estado sesion no encontrado");

		}
		estadoSesionService.deleteEstadoSesion(id);
		return ResponseEntity.ok("estado sesion eliminado correctamente");

	}

	@PutMapping("modificar/{id}")
	public ResponseEntity modificarEstadoSesion(@Valid @PathVariable Long id,
			@RequestBody EstadoSesion estadoSesion) {
		try {
			estadoSesionService.modificarEstadoSesion(id, estadoSesion);
			return ResponseEntity.ok(estadoSesion);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("datos erroneos/incompletos" + e.getMessage());
		}
	}
}

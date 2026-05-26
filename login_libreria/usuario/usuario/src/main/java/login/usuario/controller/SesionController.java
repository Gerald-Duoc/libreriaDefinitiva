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
import login.usuario.model.Sesion;
import login.usuario.service.SesionService;

@RestController
@RequestMapping("api/v1/login")
public class SesionController {
	@Autowired
	private SesionService sesionService;

	@GetMapping
	public List<Sesion> getSesiones() {
		return sesionService.getSesiones();
	}

	@GetMapping("{id}")
	public ResponseEntity getById(@Valid @PathVariable Long id) {
		Sesion sesion = sesionService.buscarId(id);
		if (sesion == null) {
			return ResponseEntity
					.status(404)
					.body("Recursos no encontrados");

		}
		return ResponseEntity.ok(sesion);
	}

	@PostMapping
	public ResponseEntity<Sesion> postSesion(@Valid @RequestBody Sesion sesion) {
		try {
			return new ResponseEntity<>(sesionService.crearSesion(sesion), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteSesion(@Valid @PathVariable Long id) {
		Sesion sesionBuscada = sesionService.buscarId(id);
		if (sesionBuscada == null) {
			return ResponseEntity
					.status(404)
					.body("tipo usuario no encontrado");

		}
		sesionService.deleteSesion(id);
		return ResponseEntity.ok("tipo usuario eliminado correctamente");
	}

	@PutMapping("modificar/{id}")
	public ResponseEntity modificarTipoUsuario(@Valid @PathVariable Long id, @RequestBody Sesion sesion) {
		Sesion sesionBuscada = sesionService.buscarId(id);
		if (sesionBuscada == null) {
			return ResponseEntity
					.status(404)
					.body("tipo usuario no encontrado");

		}
		sesionService.modificarUsuario(id, sesionBuscada);
		return ResponseEntity.ok(sesion);
	}

}

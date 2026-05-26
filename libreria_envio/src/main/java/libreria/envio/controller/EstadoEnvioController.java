
package libreria.envio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import libreria.envio.model.EstadoEnvio;
import libreria.envio.service.EstadoEnvioService;

@RestController
@RequestMapping("api/v1/estado_envio")

public class EstadoEnvioController {
	@Autowired
	public EstadoEnvioService estadoEnvioService;

	@GetMapping
	private ResponseEntity getEstadosEnvio() {
		List<EstadoEnvio> lista = estadoEnvioService.getEstadosEnvio();

		if (lista.isEmpty()) {
			return ResponseEntity
					.status(404)
					.body("Recursos no encontrados");

		}
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	public ResponseEntity<String> postEstadoEnvio(@Valid @RequestBody EstadoEnvio estadoEnvio) {
		try {
			estadoEnvioService.postEstadoEnvio(estadoEnvio);
			return ResponseEntity.ok("Estado Envio agregado exitosamente");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("datos erroneos/incompletos" + e.getMessage());
		}
	}

	@DeleteMapping("delete/{id}")
	public void deleteEstadoEnvio(@PathVariable Long id) {
		estadoEnvioService.deleteEstadoEnvio(id);
	}

	@PutMapping("modificar/{id}")
	public EstadoEnvio modificarEstadoEnvio(@PathVariable Long id, @RequestBody EstadoEnvio estadoEnvio) {
		return estadoEnvioService.modificarEstadoEnvio(id, estadoEnvio);
	}

}

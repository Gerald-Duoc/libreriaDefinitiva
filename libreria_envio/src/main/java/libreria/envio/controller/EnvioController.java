package libreria.envio.controller;

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
import libreria.envio.model.Envio;
import libreria.envio.service.EnvioService;

@RestController
@RequestMapping("api/v1/envio")

public class EnvioController {
	@Autowired
	private EnvioService envioService;

	@GetMapping
	private ResponseEntity getEnvios() {
		List<Envio> lista = envioService.getEnvios();

		if (lista.isEmpty()) {
			return ResponseEntity
					.status(404)
					.body("Recursos no encontrados");

		}
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	public ResponseEntity<String> postEnvio(@Valid @RequestBody Envio envio) {
		try {
			envioService.postEnvio(envio);
			return ResponseEntity.ok("Estado Envio agregado exitosamente");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("datos erroneos/incompletos" + e.getMessage());
		}
	}

	@DeleteMapping("delete/{id}")
	private void deleteEnvio(@PathVariable Long id) {
		envioService.deleteEnvio(id);
	}

	@PutMapping("modificar/{id}")
	private Envio modificarEnvio(@PathVariable Long id, @RequestBody Envio envio) {
		return envioService.modificarEnvio(id, envio);
	}

}

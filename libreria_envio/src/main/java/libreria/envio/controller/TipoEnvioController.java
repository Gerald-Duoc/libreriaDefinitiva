
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
import libreria.envio.model.TipoEnvio;
import libreria.envio.service.TipoEnvioService;

@RestController
@RequestMapping("api/v1/tipo_envio")

public class TipoEnvioController {
	@Autowired
	private TipoEnvioService tipoEnvioService;

	@GetMapping
	private ResponseEntity getTipoEnvio() {
		List<TipoEnvio> lista = tipoEnvioService.getTipoEnvio();

		if (lista.isEmpty()) {
			return ResponseEntity
					.status(404)
					.body("Recursos no encontrados");

		}
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	public ResponseEntity<String> postTipoEnvio(@Valid @RequestBody TipoEnvio tipoEnvio) {
		try {
			tipoEnvioService.postTipoEnvio(tipoEnvio);
			return ResponseEntity.ok("Tipo Envio agregado exitosamente");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("datos erroneos/incompletos" + e.getMessage());
		}
	}

	@DeleteMapping("delete/{id}")
	public void deleteTipoEnvio(@PathVariable Long id) {
		tipoEnvioService.deleteTipoEnvio(id);
	}

	@PutMapping("modificar/{id}")
	public TipoEnvio modificarTipoEnvio(@PathVariable Long id, @RequestBody TipoEnvio tipoEnvio) {
		return tipoEnvioService.modificarTipoEnvio(id, tipoEnvio);
	}

}

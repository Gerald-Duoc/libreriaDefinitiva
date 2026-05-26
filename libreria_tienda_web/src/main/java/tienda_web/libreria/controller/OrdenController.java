package tienda_web.libreria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tienda_web.libreria.model.Orden;
import tienda_web.libreria.service.OrdenService;

@RestController
@RequestMapping("api/v1/orden")
public class OrdenController {
	@Autowired
	private OrdenService ordenService;

	@GetMapping
	private List<Orden> getOrden() {
		return ordenService.getOrden();
	}

	@PostMapping
	private Orden postOrden(@RequestBody Orden orden) {
		return ordenService.postOrden(orden);
	}

	@DeleteMapping("delete/{id}")
	private void deleteOrden(@PathVariable Long id) {
		ordenService.deleteOrden(id);
	}

	@PutMapping("modificar/{id}")
	private Orden modificarOrden(@PathVariable Long id, @RequestBody Orden orden) {
		return ordenService.modificarOrden(id, orden);
	}

}

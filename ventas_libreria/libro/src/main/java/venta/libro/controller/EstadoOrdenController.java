package venta.libro.controller;

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

import venta.libro.model.EstadoOrden;
import venta.libro.service.EstadoOrdenService;

@RestController
@RequestMapping("api/v1/estado_orden")
public class EstadoOrdenController {
	@Autowired
	public EstadoOrdenService estadoOrdenService;

	@GetMapping
	public List<EstadoOrden> getLista() {
		return estadoOrdenService.getLista();
	}

	@PostMapping
	public EstadoOrden postEstadoOrden(@RequestBody EstadoOrden estadoOrden) {
		return estadoOrdenService.postEstadoOrden(estadoOrden);
	}

	@DeleteMapping("delete/{id}")
	public void deleteEstadoOrden(@PathVariable Long id) {
		estadoOrdenService.deleteEstadoOrden(id);
	}

	@PutMapping("modificar/{id}")
	public EstadoOrden modificarOrden(@PathVariable Long id, @RequestBody EstadoOrden estadoOrden) {
		return estadoOrdenService.modificarOrden(id, estadoOrden);
	}

}

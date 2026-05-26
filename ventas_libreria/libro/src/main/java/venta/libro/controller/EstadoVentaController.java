
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

import venta.libro.model.EstadoVenta;
import venta.libro.service.EstadoVentaService;

@RestController
@RequestMapping("api/v1/estado_venta")
public class EstadoVentaController {
	@Autowired
	public EstadoVentaService estadoVentaService;

	@GetMapping
	public List<EstadoVenta> getLista() {
		return estadoVentaService.getLista();
	}

	@PostMapping
	public EstadoVenta postEstadoOrden(@RequestBody EstadoVenta estadoVenta) {
		return estadoVentaService.postEstadoVenta(estadoVenta);
	}

	@DeleteMapping("delete/{id}")
	public void deleteEstadoVenta(@PathVariable Long id) {
		estadoVentaService.deleteEstadoVenta(id);
	}

	@PutMapping("modificar/{id}")
	public EstadoVenta modificarOrden(@PathVariable Long id, @RequestBody EstadoVenta estadoVenta) {
		return estadoVentaService.modificarOrden(id, estadoVenta);
	}

}


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

import tienda_web.libreria.model.EstadoCarrito;
import tienda_web.libreria.service.EstadoCarritoService;

@RestController
@RequestMapping("api/v1/estado_carrito")
public class EstadoCarritoController {
	@Autowired
	private EstadoCarritoService estadoCarritoService;

	@GetMapping
	public List<EstadoCarrito> getEstados() {
		return estadoCarritoService.getEstados();
	}

	@PostMapping
	public EstadoCarrito postEstadoCarrito(@RequestBody EstadoCarrito estadoCarrito) {
		return estadoCarritoService.postEstadoCarrito(estadoCarrito);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEstadoCarrito(@PathVariable Long id) {
		estadoCarritoService.deleteById(id);
	}

	@PutMapping("/modificar/{id}")
	public EstadoCarrito putEstadoCarrito(@PathVariable Long id, @RequestBody EstadoCarrito estadoCarrito) {
		return estadoCarritoService.modificarEstado(id, estadoCarrito);
	}

}

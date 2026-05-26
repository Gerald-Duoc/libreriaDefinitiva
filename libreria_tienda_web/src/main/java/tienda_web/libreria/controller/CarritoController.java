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

import tienda_web.libreria.model.Carrito;
import tienda_web.libreria.service.CarritoService;

@RestController
@RequestMapping("api/v1/carrito")
public class CarritoController {
	@Autowired
	private CarritoService carritoService;

	@GetMapping
	public List<Carrito> getCarrito() {
		return carritoService.getCarrito();
	}

	@PostMapping
	public Carrito postCarrito(@RequestBody Carrito carrito) {
		return carritoService.postCarrito(carrito);
	}

	@DeleteMapping("delete/{id}")
	public void deleteCarrito(@PathVariable Long id) {
		carritoService.deleteCarrito(id);
	}

	@PutMapping("modificar/{id}")
	public Carrito modificarCarrito(@PathVariable Long id, @RequestBody Carrito carrito) {
		return carritoService.modificarCarrito(id, carrito);
	}
}

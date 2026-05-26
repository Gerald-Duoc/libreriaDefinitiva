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

import tienda_web.libreria.model.ItemCarrito;
import tienda_web.libreria.service.ItemCarritoService;

@RestController
@RequestMapping("api/v1/itemCarrito")
public class ItemCarritoController {
	@Autowired
	private ItemCarritoService itemCarritoService;

	@GetMapping
	private List<ItemCarrito> getItemsCarrito() {
		return itemCarritoService.getItemsCarrito();
	}

	@PostMapping
	private ItemCarrito postItemCarrito(@RequestBody ItemCarrito itemCarrito) {
		return itemCarritoService.postItemCarrito(itemCarrito);
	}

	@DeleteMapping("delete/{id}")
	private void deleteItemCarrito(@PathVariable Long id) {
		itemCarritoService.deleteItemCarrito(id);
	}

	@PutMapping("modificar/{id}")
	private ItemCarrito modificarItemMapping(@PathVariable Long id, @RequestBody ItemCarrito itemCarrito) {
		return itemCarritoService.modificarItemMapping(id, itemCarrito);
	}

}

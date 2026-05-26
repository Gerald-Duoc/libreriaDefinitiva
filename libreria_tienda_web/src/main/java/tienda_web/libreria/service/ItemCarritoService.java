package tienda_web.libreria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienda_web.libreria.model.ItemCarrito;
import tienda_web.libreria.repository.ItemCarritoRepository;

@Service
public class ItemCarritoService {
	@Autowired
	private ItemCarritoRepository itemCarritoRepository;

	public List<ItemCarrito> getItemsCarrito() {
		return itemCarritoRepository.findAll();
	}

	public ItemCarrito postItemCarrito(ItemCarrito itemCarrito) {
		return itemCarritoRepository.save(itemCarrito);
	}

	public void deleteItemCarrito(Long id) {
		itemCarritoRepository.deleteById(id);
	}

	public ItemCarrito modificarItemMapping(Long id, ItemCarrito itemCarrito) {
		ItemCarrito itemNuevo = itemCarritoRepository.findById(id).orElse(null);
		if (itemNuevo != null) {
			itemNuevo.setCantidad(itemCarrito.getCantidad());
		}
		return null;
	}

}

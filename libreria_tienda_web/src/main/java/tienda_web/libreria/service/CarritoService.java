
package tienda_web.libreria.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienda_web.libreria.model.Carrito;
import tienda_web.libreria.repository.CarritoRepository;

@Service
public class CarritoService {
	@Autowired
	private CarritoRepository carritoRepository;

	public List<Carrito> getCarrito() {
		return carritoRepository.findAll();
	}

	public Carrito postCarrito(Carrito carrito) {
		carrito.setFechaCreacion(new Date());
		carrito.setUltimaActualizacion(new Date());
		return carritoRepository.save(carrito);
	}

	public Carrito modificarCarrito(Long id, Carrito carrito) {
		Carrito carritoViejo = carritoRepository.findById(id).orElse(null);
		if (carritoViejo != null) {
			carritoViejo.setUltimaActualizacion(new Date());
			carritoViejo.setEstadoCarrito(carrito.getEstadoCarrito());
			return carritoRepository.save(carritoViejo);
		}
		return null;
	}

	public void deleteCarrito(Long id) {
		carritoRepository.deleteById(id);
	}

}

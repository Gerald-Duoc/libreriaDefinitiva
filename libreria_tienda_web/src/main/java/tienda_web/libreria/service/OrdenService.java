package tienda_web.libreria.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienda_web.libreria.model.Orden;
import tienda_web.libreria.repository.OrdenRepository;

@Service
public class OrdenService {
	@Autowired
	private OrdenRepository ordenRepository;

	public List<Orden> getOrden() {
		return ordenRepository.findAll();
	}

	public Orden postOrden(Orden orden) {
		orden.setFechaOrden(new Date());
		orden.setTotal(orden.getSubtotal() + orden.getImpuestos());
		return ordenRepository.save(orden);
	}

	public void deleteOrden(Long id) {
		ordenRepository.deleteById(id);
	}

	public Orden modificarOrden(Long id, Orden orden) {
		Orden ordenCambio = ordenRepository.findById(id).orElse(null);
		if (ordenCambio != null) {
			if (orden.getFechaOrden() != null) {
				ordenCambio.setFechaOrden(orden.getFechaOrden());
			}
			ordenCambio.setSubtotal(orden.getSubtotal());
			ordenCambio.setImpuestos(orden.getImpuestos());
			ordenCambio.setTotal(orden.getSubtotal() + orden.getImpuestos());
			ordenCambio.setTotal(orden.getTotal());
			return ordenRepository.save(ordenCambio);

		}
		return null;
	}

	private Date fechaOrden;

	private double subtotal;

	private double impuestos;

	private double total;
}

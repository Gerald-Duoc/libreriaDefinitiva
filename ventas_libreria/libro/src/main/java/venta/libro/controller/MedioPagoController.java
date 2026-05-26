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

import venta.libro.model.MedioPago;
import venta.libro.service.MedioPagoService;

@RestController
@RequestMapping("api/v1/medio_pago")
public class MedioPagoController {
	@Autowired
	public MedioPagoService medioPagoService;

	@GetMapping
	public List<MedioPago> getLista() {
		return medioPagoService.getLista();
	}

	@PostMapping
	public MedioPago postMedioPago(@RequestBody MedioPago medioPago) {
		return medioPagoService.postEstadoVenta(medioPago);
	}

	@DeleteMapping("delete/{id}")
	public void deleteEstadoVenta(@PathVariable Long id) {
		medioPagoService.deleteEstadoVenta(id);
	}

	@PutMapping("modificar/{id}")
	public MedioPago modificarOrden(@PathVariable Long id, @RequestBody MedioPago medioPago) {
		return medioPagoService.modificarOrden(id, medioPago);
	}

}

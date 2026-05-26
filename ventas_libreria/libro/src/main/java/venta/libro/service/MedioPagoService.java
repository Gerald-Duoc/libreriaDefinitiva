package venta.libro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import venta.libro.model.MedioPago;
import venta.libro.repository.MedioPagoRepository;

@Service
public class MedioPagoService {
	@Autowired
	public MedioPagoRepository medioPagoRepository;

	public List<MedioPago> getLista() {
		return medioPagoRepository.findAll();
	}

	public MedioPago postEstadoVenta(MedioPago medioPago) {
		return medioPagoRepository.save(medioPago);
	}

	public MedioPago modificarOrden(Long id, MedioPago medioPago) {
		MedioPago medioPagoCambio = medioPagoRepository.findById(id).orElse(null);
		if (medioPagoCambio != null) {
			medioPagoCambio.setNombre(medioPago.getNombre());
		}
		return null;
	}

	public void deleteEstadoVenta(Long id) {
		medioPagoRepository.deleteById(id);
	}
}

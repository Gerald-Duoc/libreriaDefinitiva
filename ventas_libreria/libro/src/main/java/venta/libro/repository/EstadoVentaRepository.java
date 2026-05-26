package venta.libro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import venta.libro.model.EstadoVenta;

public interface EstadoVentaRepository extends JpaRepository<EstadoVenta, Long> {

}

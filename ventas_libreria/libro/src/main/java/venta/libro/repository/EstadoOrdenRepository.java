package venta.libro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import venta.libro.model.EstadoOrden;

public interface EstadoOrdenRepository extends JpaRepository<EstadoOrden, Long> {

}

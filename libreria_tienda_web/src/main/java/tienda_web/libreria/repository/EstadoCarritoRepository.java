package tienda_web.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda_web.libreria.model.EstadoCarrito;

public interface EstadoCarritoRepository extends JpaRepository<EstadoCarrito, Long> {
}

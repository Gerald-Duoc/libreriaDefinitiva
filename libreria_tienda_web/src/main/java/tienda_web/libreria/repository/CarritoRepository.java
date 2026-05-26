package tienda_web.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda_web.libreria.model.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {
}

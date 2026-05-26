package tienda_web.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda_web.libreria.model.ItemCarrito;

public interface ItemCarritoRepository extends JpaRepository<ItemCarrito, Long> {
}

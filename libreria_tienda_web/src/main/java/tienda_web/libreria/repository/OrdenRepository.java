
package tienda_web.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda_web.libreria.model.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
}

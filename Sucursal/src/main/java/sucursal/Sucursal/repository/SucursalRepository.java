package sucursal.Sucursal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sucursal.Sucursal.model.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
    
}

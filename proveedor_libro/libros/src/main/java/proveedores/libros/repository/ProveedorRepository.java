package proveedores.libros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proveedores.libros.model.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor,Long>{
    
}

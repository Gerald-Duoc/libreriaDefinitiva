package proveedores.libros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proveedores.libros.model.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud,Long>{
    
}

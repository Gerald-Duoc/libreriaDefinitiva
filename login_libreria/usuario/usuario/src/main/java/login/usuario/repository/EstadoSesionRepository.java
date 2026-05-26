package login.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import login.usuario.model.EstadoSesion;

public interface EstadoSesionRepository extends JpaRepository<EstadoSesion, Long> {
}

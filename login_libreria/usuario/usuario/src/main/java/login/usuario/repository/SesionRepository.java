package login.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import login.usuario.model.Sesion;

public interface SesionRepository extends JpaRepository<Sesion, Long> {

}

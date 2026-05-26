package libreria.envio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import libreria.envio.model.Envio;

public interface EnvioRepository extends JpaRepository<Envio, Long> {
}


package libreria.envio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import libreria.envio.model.EstadoEnvio;

public interface EstadoEnvioRepository extends JpaRepository<EstadoEnvio, Long> {
}

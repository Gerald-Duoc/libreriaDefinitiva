package libreria.envio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import libreria.envio.model.TipoEnvio;

public interface TipoEnvioRepository extends JpaRepository<TipoEnvio, Long> {
}

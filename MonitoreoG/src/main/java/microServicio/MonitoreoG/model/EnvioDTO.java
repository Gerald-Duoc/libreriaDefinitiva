package microServicio.MonitoreoG.model;

import lombok.Data;

@Data
public class EnvioDTO {

    private Long idEnvio;
    private String estado;
    private String direccion;
}

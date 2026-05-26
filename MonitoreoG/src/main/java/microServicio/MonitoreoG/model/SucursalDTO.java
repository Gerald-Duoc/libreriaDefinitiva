package microServicio.MonitoreoG.model;

import lombok.Data;

@Data
public class SucursalDTO {

    private Long idSucursal;

    private String nombre;

    private String direccion;

    private String ciudad;

    private String telefono;

    private String encargado;

    
}

package microServicio.MonitoreoG.model;

import lombok.Data;

@Data
public class LibroDTO {

    private Long idLibro;

    private String titulo;

    private String autor;

    private int stock;

    private double precio;

    private String categoria;
    
}

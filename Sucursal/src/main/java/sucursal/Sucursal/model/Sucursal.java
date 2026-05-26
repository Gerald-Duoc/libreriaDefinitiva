package sucursal.Sucursal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSucursal;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100,message = "El nombre no puede superar 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "La direccion es obligatoria")
    @Size(max = 150,message = "La direccion no puede superar 150 caracteres")
    @Column(nullable = false, length = 150)
    private String direccion;

    @NotBlank(message = "La ciudad es obligatoria")
    @Size(max = 100,message = "La ciudad no puede superar 100 caracteres")
    @Column(nullable = false, length = 100)
    private String ciudad;

    @NotBlank(message = "El telefono es obligatorio")
    @Size(max = 20,message = "El telefono no puede superar 20 caracteres")
    @Column(nullable = false, length = 20)
    private String telefono;

    @NotBlank(message = "El encargado es obligatorio")
    @Size(max = 100,message = "El encargado no puede superar 100 caracteres")
    @Column(nullable = false, length = 100)
    private String encargado;
    
}

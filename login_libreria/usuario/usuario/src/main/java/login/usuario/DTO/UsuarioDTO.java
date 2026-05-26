package login.usuario.DTO;

import lombok.Data;

@Data
public class UsuarioDTO {
	private Long id;
	private String nombreCompleto;

	public String getNombreCompleto() {
		return nombreCompleto;
	}
}

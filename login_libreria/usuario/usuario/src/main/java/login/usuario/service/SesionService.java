package login.usuario.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.validation.Valid;
import login.usuario.DTO.UsuarioDTO;
import login.usuario.model.Sesion;
import login.usuario.repository.SesionRepository;

@Service
public class SesionService {

	@Autowired
	private SesionRepository sesionRepository;

	@Autowired
	private RestTemplate restTemplate;

	public List<Sesion> getSesiones() {
		return sesionRepository.findAll();
	}

	public Sesion crearSesion(@Valid Sesion sesion) {
		String url = "http://localhost:8087/api/v1/usuarios/buscarid/" + sesion.getIdUsuario();
		UsuarioDTO usuario = restTemplate.getForObject(url, UsuarioDTO.class);

		if (usuario != null) {
			sesion.setNombreCompleto(usuario.getNombreCompleto());
			sesion.setFechaInicio(new Date());
			System.out.println("------------------");
			System.out.println(sesion);
			return sesionRepository.save(sesion);
		}
		return null;
	}

	public Sesion buscarId(@Valid Long id) {
		return sesionRepository.findById(id).orElse(null);
	}

	public void deleteSesion(@Valid Long id) {
		sesionRepository.deleteById(id);
	}

	public Sesion modificarUsuario(@Valid Long id, Sesion sesion) {
		Sesion sesionCambiada = sesionRepository.findById(id).orElse(null);
		if (sesionCambiada != null) {
			return sesionRepository.save(sesionCambiada);
		}

		return null;
	}

}

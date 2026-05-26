package microServicio.MonitoreoG.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import microServicio.MonitoreoG.model.EnvioDTO;
import microServicio.MonitoreoG.model.LibroDTO;
import microServicio.MonitoreoG.model.ProveedorDTO;
import microServicio.MonitoreoG.model.SucursalDTO;
import microServicio.MonitoreoG.model.UsuarioDTO;
import microServicio.MonitoreoG.model.VentaDTO;

@Service
public class MonitoreoService {

    @Autowired
    private RestTemplate restTemplate;

    public List<LibroDTO> obtenerLibros() {

        String url ="http://localhost:8082/api/v1/libros";

        try {

            LibroDTO[] libros = restTemplate.getForObject(url,LibroDTO[].class);

            return Arrays.asList(libros);
        } catch (Exception e) {
            return List.of();
        }
    }

    public List<SucursalDTO> obtenerSucursales() {

        String url ="http://localhost:8084/api/v1/sucursales";

        SucursalDTO[] sucursales =restTemplate.getForObject(url,SucursalDTO[].class);
        
        return Arrays.asList(sucursales);
    }

    public List<UsuarioDTO> obtenerUsuarios() {

    String url ="http://localhost:8087/api/v1/usuarios";

    UsuarioDTO[] usuarios = restTemplate.getForObject(url,UsuarioDTO[].class);
    
    return Arrays.asList(usuarios);
    }
    
    public List<EnvioDTO> obtenerEnvios() {

    String url ="http://localhost:8086/api/v1/envio";

    EnvioDTO[] envios = restTemplate.getForObject(url,EnvioDTO[].class);

    return Arrays.asList(envios);
    }

    public List<ProveedorDTO> obtenerProveedores() {
        ProveedorDTO[] respuesta = restTemplate.getForObject("http://localhost:8091/api/v1/proveedor",ProveedorDTO[].class);
        return Arrays.asList(respuesta);
    }

    public List<VentaDTO> obtenerVentas() {

    VentaDTO[] respuesta = restTemplate.getForObject("http://localhost:8092/api/v1/ventas",VentaDTO[].class);
    
    return Arrays.asList(respuesta);
    }
}

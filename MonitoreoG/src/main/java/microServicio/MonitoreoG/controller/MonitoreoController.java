package microServicio.MonitoreoG.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microServicio.MonitoreoG.model.EnvioDTO;
import microServicio.MonitoreoG.model.LibroDTO;
import microServicio.MonitoreoG.model.ProveedorDTO;
import microServicio.MonitoreoG.model.SucursalDTO;
import microServicio.MonitoreoG.model.UsuarioDTO;
import microServicio.MonitoreoG.model.VentaDTO;
import microServicio.MonitoreoG.service.MonitoreoService;

@RestController
@RequestMapping("/api/v1/monitoreo")
public class MonitoreoController {

    @Autowired
    private MonitoreoService service;

    @GetMapping("/libros")
    public List<LibroDTO> libros() {
        return service.obtenerLibros();
    }

    @GetMapping("/sucursales")
    public List<SucursalDTO> sucursales() {
        return service.obtenerSucursales();
    }

    @GetMapping("/usuarios")
    public List<UsuarioDTO> usuarios() {
        return service.obtenerUsuarios();
    }

    @GetMapping("/envios")
        
    public List<EnvioDTO> envios() {
        return service.obtenerEnvios();
    }

    @GetMapping("/proveedores")
    public List<ProveedorDTO> proveedores() {
        return service.obtenerProveedores();
    }

    @GetMapping("/ventas")
    public List<VentaDTO> ventas() {
        return service.obtenerVentas();
    }

    @GetMapping("/resumen")
    public Map<String, Object> resumen() {List<LibroDTO> libros = service.obtenerLibros();

        List<SucursalDTO> sucursales = service.obtenerSucursales();

        List<UsuarioDTO> usuarios = service.obtenerUsuarios();

        List<EnvioDTO> envios = service.obtenerEnvios();

        int stockTotal = libros.stream().mapToInt(LibroDTO::getStock).sum();

        Map<String, Object> datos = new HashMap<>();

        datos.put("totalLibros", libros.size());

        datos.put("stockTotal", stockTotal);

        datos.put("totalSucursales", sucursales.size());

        datos.put("totalUsuarios", usuarios.size());

        datos.put("totalEnvios", envios.size());

        return datos;
} 


}

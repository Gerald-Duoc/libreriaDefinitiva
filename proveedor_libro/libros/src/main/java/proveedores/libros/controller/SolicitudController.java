package proveedores.libros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proveedores.libros.model.Solicitud;
import proveedores.libros.service.SolicitudService;

@RestController
@RequestMapping("api/v1/solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @PostMapping()
    public Solicitud postProveedor(@RequestBody Solicitud proveedor){
        return solicitudService.crear(proveedor);
    }
    @GetMapping()
    public List<Solicitud>getProveedor(){
        return solicitudService.listar();
    }
    @PutMapping("{id}")
    public Solicitud putProveedor(@PathVariable Long id, @RequestBody Solicitud proveedor){
        return solicitudService.modificar(id, proveedor);
    }

    @DeleteMapping("{id}")
    public void deleteProveedor(@PathVariable Long id){
        solicitudService.eliminar(id);
    }

    
}

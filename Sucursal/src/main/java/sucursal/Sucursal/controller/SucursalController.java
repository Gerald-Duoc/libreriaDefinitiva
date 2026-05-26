package sucursal.Sucursal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sucursal.Sucursal.model.Sucursal;
import sucursal.Sucursal.service.SucursalService;

@RestController
@RequestMapping("/api/v1/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService service;

    @GetMapping
    public List<Sucursal> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Sucursal> guardar(@Valid @RequestBody Sucursal sucursal) {
        
        return new ResponseEntity<>(service.guardar(sucursal),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar() {
        List<Sucursal> lista = service.listar();

        if(lista.isEmpty()) {

            return ResponseEntity.status(404).body("No hay sucursales registradas");
            }
            return ResponseEntity.ok(lista);
    }

    

    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> actualizar(@PathVariable Long id,@Valid @RequestBody Sucursal nuevaSucursal) {

        return service.buscar(id).map(sucursal -> {
            sucursal.setNombre(nuevaSucursal.getNombre());

            sucursal.setDireccion(nuevaSucursal.getDireccion());

            sucursal.setCiudad(nuevaSucursal.getCiudad());

            sucursal.setTelefono(nuevaSucursal.getTelefono());

            sucursal.setEncargado(nuevaSucursal.getEncargado());

            return ResponseEntity.ok(service.guardar(sucursal));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        return service.buscar(id).map(sucursal -> {

            service.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            })
            .orElse(ResponseEntity.notFound().build());
    }
}

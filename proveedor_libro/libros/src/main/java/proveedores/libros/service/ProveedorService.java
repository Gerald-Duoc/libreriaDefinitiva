package proveedores.libros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import proveedores.libros.model.Proveedor;
import proveedores.libros.repository.ProveedorRepository;

@Service
@Transactional
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

     public Proveedor crear(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
        
    }

    public List<Proveedor> listar() {
        return proveedorRepository.findAll();
    }

    public Proveedor modificar(Long id, Proveedor proveedor) {
        Proveedor existente = proveedorRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(proveedor.getNombre());
            existente.setRut(proveedor.getRut());
            existente.setDireccion(proveedor.getDireccion());
            existente.setTelefono(proveedor.getTelefono());
            existente.setEmail(proveedor.getEmail());
            existente.setFechaRegistro(proveedor.getFechaRegistro());

            existente.setActivo(proveedor.isActivo());
            
            return proveedorRepository.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        proveedorRepository.deleteById(id);
       
    }
    
}

package sucursal.Sucursal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sucursal.Sucursal.model.Sucursal;
import sucursal.Sucursal.repository.SucursalRepository;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository repository;

    public List<Sucursal> listar() {
        return repository.findAll();
    }

    public Sucursal guardar(Sucursal sucursal) {
        return repository.save(sucursal);
    }

    public Optional<Sucursal> buscar(Long id) {
        return repository.findById(id);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
    
}

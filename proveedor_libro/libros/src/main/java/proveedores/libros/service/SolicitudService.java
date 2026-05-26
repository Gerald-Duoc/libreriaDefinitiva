package proveedores.libros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import proveedores.libros.model.Solicitud;

import proveedores.libros.repository.SolicitudRepository;

@Service
@Transactional
public class SolicitudService {
    @Autowired
    private SolicitudRepository solicitudRepository;

    public Solicitud crear(Solicitud solicitud){
        return solicitudRepository.save(solicitud);
    }
    public List <Solicitud> listar(){
        return solicitudRepository.findAll();
    }
public Solicitud modificar(Long id, Solicitud solicitud) {
        Solicitud existente = solicitudRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setIdSucursal(solicitud.getIdSucursal());
            existente.setFechaSolicitud(solicitud.getFechaSolicitud());
            existente.setEstadoSolicitud(solicitud.getEstadoSolicitud());
            existente.setObservaciones(solicitud.getObservaciones());
            existente.setCantidadSolicitada(solicitud.getCantidadSolicitada());
            existente.setProveedor(solicitud.getProveedor());
            
            return solicitudRepository.save(existente);
        }
        return null;
    }
    public void eliminar(Long id){
        solicitudRepository.deleteById(id);
    }
}

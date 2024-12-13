package desarrollo01.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrollo01.models.DetalleOrdenModel;
import desarrollo01.repositories.DetalleOrdenRepository;

@Service
public class DetalleOrdenService {
    
    @Autowired
    DetalleOrdenRepository detalleOrdenRepository;

    public ArrayList<DetalleOrdenModel> obtenerDetalleOrdenes() {
        return (ArrayList<DetalleOrdenModel>) detalleOrdenRepository.findAll();
    }

    public DetalleOrdenModel guardarDetalleOrden(DetalleOrdenModel detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

    public Optional<DetalleOrdenModel> obtenerDetalleOrdenPorID(Long id_detalleOrden) {
        return detalleOrdenRepository.findById(id_detalleOrden);
    }

    public boolean eliminarDetalleOrden(Long id_detalleOrden) {
        try {
            detalleOrdenRepository.deleteById(id_detalleOrden);
            return true;
        } catch (Exception error) {
            return false;
        }
    }

    public double obtenerTotal(Long id) {
        DetalleOrdenModel detalle = this.detalleOrdenRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Detalle de orden no encontrado con ID: " + id));
        return detalle.getTotal();
    }
}

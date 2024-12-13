package desarrollo01.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrollo01.models.DetalleOrdenModel;
import desarrollo01.models.OrdenModel;
import desarrollo01.repositories.OrdenRepository;

@Service
public class OrdenService {

    @Autowired
    OrdenRepository ordenRepository;

    public ArrayList<OrdenModel> obtenerOrdens() {
        return (ArrayList<OrdenModel>) ordenRepository.findAll();
    }

    public OrdenModel guardarOrden(OrdenModel orden) {
        return ordenRepository.save(orden);
    }

    public Optional<OrdenModel> obtenerOrdenPorID(Long id_orden) {
        return ordenRepository.findById(id_orden);
    }

    public boolean eliminarOrden(Long id_orden) {
        try {
            ordenRepository.deleteById(id_orden);
            return true;
        } catch (Exception error) {
            return false;
        }
    }

    public double calcularTotal(Long id) {
        OrdenModel orden = ordenRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        double total = 0.0;
        for (DetalleOrdenModel detalle : orden.getDetalles()) {
            total += detalle.getTotal();
        }
        return total;
    }
}

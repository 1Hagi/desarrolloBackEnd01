package desarrollo01.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrollo01.models.PagoModel;
import desarrollo01.models.OrdenModel;
import desarrollo01.repositories.PagoRepository;
import desarrollo01.repositories.OrdenRepository;

@Service
public class PagoService {

    @Autowired
    PagoRepository pagoRepository;
    @Autowired
    OrdenRepository ordenRepository;

    public ArrayList<PagoModel> obtenerPagos() {
        return (ArrayList<PagoModel>) pagoRepository.findAll();
    }

    public PagoModel guardarPago(PagoModel pago) {
        OrdenModel orden = ordenRepository.findById((long) pago.getOrden().getId_orden())
                .orElseThrow(() -> new RuntimeException("Orden no encontrado"));
        pago.setOrden(orden);
        return pagoRepository.save(pago);
    }

    public Optional<PagoModel> obtenerPagoPorID(Long id_pago) {
        return pagoRepository.findById(id_pago);
    }

    public boolean eliminarPago(Long id_pago) {
        try {
            pagoRepository.deleteById(id_pago);
            return true;
        } catch (Exception error) {
            return false;
        }
    } 
}
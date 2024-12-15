package desarrollo01.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import desarrollo01.models.PagoModel;
import desarrollo01.services.PagoService;

@RestController
@RequestMapping("/pago")
public class PagoController {

    @Autowired
    PagoService pagoService;

    @GetMapping()
    public ArrayList<PagoModel> obtenerPagos() {
        return pagoService.obtenerPagos();
    }

    @PostMapping
    public PagoModel guardarPago(@RequestBody PagoModel pago) {
        return this.pagoService.guardarPago(pago);
    }

    @GetMapping(path = "/{id}")
    public Optional<PagoModel> obtenerPagoPorID(@PathVariable("id") Long id_pago) {
        return this.pagoService.obtenerPagoPorID(id_pago);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.pagoService.eliminarPago(id);
        if (ok) {
            return "Se eliminio Pago con id: " + id;
        } else {
            return "No se pudo eliminar Pago con id: " + id;
        }
    }
}

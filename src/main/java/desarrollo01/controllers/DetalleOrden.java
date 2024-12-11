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

import desarrollo01.models.DetalleOrdenModel;
import desarrollo01.services.DetalleOrdenService;

@RestController
@RequestMapping("/detalleorden")
public class DetalleOrden {

    @Autowired
    DetalleOrdenService detalleOrdenService;

    @GetMapping()
    public ArrayList<DetalleOrdenModel> obtenerDetalleOrdenes() {
        return detalleOrdenService.obtenerDetalleOrdenes();
    }

    @PostMapping
    public DetalleOrdenModel guardarDetalleOrden(@RequestBody DetalleOrdenModel detalleOrden) {
        return this.detalleOrdenService.guardarDetalleOrden(detalleOrden);
    }

    @GetMapping(path = "/{id}")
    public Optional<DetalleOrdenModel> obtenerDetalleOrdenPorID(@PathVariable("id") Long id) {
        return this.detalleOrdenService.obtenerDetalleOrdenPorID(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.detalleOrdenService.eliminarDetalleOrden(id);
        if (ok) {
            return "Se eliminio DetalleOrden con id: " + id;
        } else {
            return "No se pudo eliminar DetalleOrden con id: " + id;
        }
    }

    @GetMapping("{id}/total")
    public ResponseEntity<Double> obtenerDetalleOrdenPorId(@RequestParam("id") Long id) {
        double total = this.detalleOrdenService.obtenerTotal(id);
        return ResponseEntity.ok(total);
    }
}

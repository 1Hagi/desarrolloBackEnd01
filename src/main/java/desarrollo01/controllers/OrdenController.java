package desarrollo01.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desarrollo01.models.OrdenModel;
import desarrollo01.services.OrdenService;

@RestController
@RequestMapping("/orden")
public class OrdenController {

    @Autowired
    OrdenService ordenService;

    @GetMapping()
    public ArrayList<OrdenModel> obtenerOrdens() {
        return ordenService.obtenerOrdens();
    }

    @PostMapping
    public OrdenModel guardarOrden(@RequestBody OrdenModel orden) {
        return this.ordenService.guardarOrden(orden);
    }

    @GetMapping(path = "/{id}")
    public Optional<OrdenModel> obtenerOrdenPorID(@PathVariable("id") Long id_orden) {
        return this.ordenService.obtenerOrdenPorID(id_orden);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.ordenService.eliminarOrden(id);
        if (ok) {
            return "Se eliminio Orden con id: " + id;
        } else {
            return "No se pudo eliminar Orden con id: " + id;
        }
    }
}

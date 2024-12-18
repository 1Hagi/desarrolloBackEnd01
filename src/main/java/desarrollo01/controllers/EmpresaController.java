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

import desarrollo01.models.EmpresaModel;
import desarrollo01.services.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    
    @Autowired
    EmpresaService empresaService;

    @GetMapping()
    public ArrayList<EmpresaModel> obtenerEmpresas() {
        return empresaService.obtenerEmpresas();
    }

    @PostMapping
    public EmpresaModel guardarEmpresa(@RequestBody EmpresaModel empresa) {
        return this.empresaService.guardarEmpresa(empresa);
    }

    @GetMapping(path = "/{id}")
    public Optional<EmpresaModel> obtenerEmpresaPorID(@PathVariable("id") Long id_empresa) {
        return this.empresaService.obtenerEmpresaPorID(id_empresa);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.empresaService.eliminarEmpresa(id);
        if (ok) {
            return "Se eliminio empresa con id: " + id;
        } else {
            return "No se pudo eliminar empresa con id: " + id;
        }
    }
}

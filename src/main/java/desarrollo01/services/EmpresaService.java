package desarrollo01.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrollo01.models.EmpresaModel;
import desarrollo01.repositories.EmpresaRepository;

@Service
public class EmpresaService {
    
    @Autowired
    EmpresaRepository empresaRepository;

    public ArrayList<EmpresaModel> obtenerEmpresas() {
        return (ArrayList<EmpresaModel>) empresaRepository.findAll();
    }

    public EmpresaModel guardarEmpresa(EmpresaModel empresa) {
        return empresaRepository.save(empresa);
    }

    public Optional<EmpresaModel> obtenerEmpresaPorID(Long id_empresa) {
        return empresaRepository.findById(id_empresa);
    }

    public boolean eliminarEmpresa(Long id_empresa) {
        try {
            empresaRepository.deleteById(id_empresa);
            return true;
        } catch (Exception error) {
            return false;
        }
    }
}

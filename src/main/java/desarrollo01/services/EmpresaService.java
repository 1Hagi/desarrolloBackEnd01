package desarrollo01.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrollo01.models.EmpresaModel;
import desarrollo01.models.UsuarioModel;
import desarrollo01.repositories.EmpresaRepository;
import desarrollo01.repositories.UsuarioRepository;

@Service
public class EmpresaService {
    
    @Autowired
    EmpresaRepository empresaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<EmpresaModel> obtenerEmpresas() {
        return (ArrayList<EmpresaModel>) empresaRepository.findAll();
    }

    public EmpresaModel guardarEmpresa(EmpresaModel empresa) {
        UsuarioModel usuario = usuarioRepository.findById((long) empresa.getUsuario().getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        empresa.setUsuario(usuario);
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

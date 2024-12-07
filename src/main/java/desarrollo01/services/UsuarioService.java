package desarrollo01.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desarrollo01.models.UsuarioModel;
import desarrollo01.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorID(Long id_usuario) {
        return usuarioRepository.findById(id_usuario);
    }

    public ArrayList<UsuarioModel> obtenerPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    public boolean eliminarUsuario(Long id_usuario) {
        try {
            usuarioRepository.deleteById(id_usuario);
            return true;
        } catch (Exception error) {
            return false;
        }
    }
}
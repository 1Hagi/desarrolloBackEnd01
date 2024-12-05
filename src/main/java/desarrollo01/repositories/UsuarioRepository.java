package desarrollo01.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import desarrollo01.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    
}
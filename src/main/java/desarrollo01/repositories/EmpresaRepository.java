package desarrollo01.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import desarrollo01.models.EmpresaModel;

@Repository
public interface EmpresaRepository extends CrudRepository<EmpresaModel, Long> {
    
}

package desarrollo01.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import desarrollo01.models.PagoModel;

@Repository
public interface PagoRepository extends CrudRepository<PagoModel, Long> {
    
}
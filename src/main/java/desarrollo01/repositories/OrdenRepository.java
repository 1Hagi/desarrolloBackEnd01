package desarrollo01.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import desarrollo01.models.OrdenModel;

@Repository
public interface OrdenRepository extends CrudRepository<OrdenModel, Long> {
    
}
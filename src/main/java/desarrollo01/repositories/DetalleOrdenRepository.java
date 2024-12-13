package desarrollo01.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import desarrollo01.models.DetalleOrdenModel;

@Repository
public interface DetalleOrdenRepository extends CrudRepository<DetalleOrdenModel, Long> {
    
}

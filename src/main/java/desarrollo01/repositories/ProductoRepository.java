package desarrollo01.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import desarrollo01.models.ProductoModel;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Long> {
    
}
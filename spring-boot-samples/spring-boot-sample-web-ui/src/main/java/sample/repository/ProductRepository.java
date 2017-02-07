package sample.repository;

import org.springframework.data.repository.CrudRepository;
import sample.domain.Product;

/**
 * Created by matthijs on 7-2-17.
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
}

package sample.repository;

import org.springframework.data.repository.CrudRepository;
import sample.domain.ProductCatalog;

/**
 * Created by matthijs on 7-2-17.
 */
public interface ProductCatalogRepository extends CrudRepository<ProductCatalog, Long> {
}

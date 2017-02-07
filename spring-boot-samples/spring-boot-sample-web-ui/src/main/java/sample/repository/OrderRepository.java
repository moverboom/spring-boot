package sample.repository;

import org.springframework.data.repository.CrudRepository;
import sample.domain.Order;

/**
 * Created by matthijs on 7-2-17.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}

package sample.domain;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by matthijs on 7-2-17.
 */

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    @MapKey(name = "id")
    private Map<Long, Product> products;

    public Order() {
        this.products = new HashMap<Long, Product>();
    }

    public void addProduct(Product product) {
        if(!products.containsKey(product.getId())) {
            products.put(product.getId(), product);
        }
    }
}

package sample.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sample.domain.Product;
import sample.domain.ProductCatalog;
import sample.repository.ProductCatalogRepository;
import sample.domain.Order;
import sample.repository.OrderRepository;
import sample.repository.ProductRepository;

/**
 * Created by matthijs on 7-2-17.
 */
@Controller
@RequestMapping("/crud")
public class TestCrudController {

    private final ProductRepository productRepository;

    private final ProductCatalogRepository productCatalogRepository;

    private final OrderRepository orderRepository;

    @Autowired
    public TestCrudController(ProductRepository productRepository, ProductCatalogRepository productCatalogRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.productCatalogRepository = productCatalogRepository;
        this.orderRepository = orderRepository;
    }

    public void createEntities() {
        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog = productCatalogRepository.save(productCatalog);

        Product product1 = new Product("Product 1", 20);
        Product product2 = new Product("Product 2", 45);
        product1 = productRepository.save(product1);
        product2 = productRepository.save(product2);

        Order order = new Order();
        order = orderRepository.save(order);

        productCatalog.addProduct(product1);
        productCatalog.addProduct(product2);
        productCatalogRepository.save(productCatalog);

        //Find product

        order.addProduct(product2);
        orderRepository.save(order);
    }

    @GetMapping
    public ModelAndView list() {
        createEntities();

        return new ModelAndView("redirect:/");
    }

}

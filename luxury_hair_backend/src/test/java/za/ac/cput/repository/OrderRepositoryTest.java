package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OrderRepositoryTest {
    private OrderRepository Repository;

    private Order order;
    @BeforeEach
    void setUp() {
        order= OrderFactory.buildOrder("R2435", 4,  3500.0, "12-04-2024", "delivered", "12 wrench road", "courier","cash");
        assertNotNull(order);
        System.out.println(order);
    }
    @Test
    void findOrderById(){
        order=Repository.findOrderByOrderID("R2435");
        System.out.println(order);

    }
}

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderFactoryTest {
    @Test
    void buildOrder(){
        Order order= OrderFactory.buildOrder("R2435",2,300.0,"20-04-2024","delivered","12 wrench road","courier","cash");
        assertNotNull(order);
        System.out.println(order);
    }
}

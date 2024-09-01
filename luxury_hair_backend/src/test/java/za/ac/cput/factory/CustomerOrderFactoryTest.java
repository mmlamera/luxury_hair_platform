package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.CustomerOrder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerOrderFactoryTest {
    @Test
    void buildCustomerOrder(){
        CustomerOrder customerOrder = CustomerOrderFactory.buildCustomerOrder("R2435",2,300.0,"20-04-2024","delivered","12 wrench road","courier","cash");
        assertNotNull(customerOrder);
        System.out.println(customerOrder);
    }
}

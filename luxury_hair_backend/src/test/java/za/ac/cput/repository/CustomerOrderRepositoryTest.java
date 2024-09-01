package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.CustomerOrder;
import za.ac.cput.factory.CustomerOrderFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustomerOrderRepositoryTest {
    private CustomerOrderRepository Repository;

    private CustomerOrder customerOrder;
    @BeforeEach
    void setUp() {
        customerOrder = CustomerOrderFactory.buildCustomerOrder("R2435", 4,  3500.0, "12-04-2024", "delivered", "12 wrench road", "courier","cash");
        assertNotNull(customerOrder);
        System.out.println(customerOrder);
    }
    @Test
    void findOrderById(){
        customerOrder =Repository.findOrderByOrderID("R2435");
        System.out.println(customerOrder);

    }
}

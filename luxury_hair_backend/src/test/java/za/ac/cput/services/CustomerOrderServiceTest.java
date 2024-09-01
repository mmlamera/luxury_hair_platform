package za.ac.cput.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.CustomerOrder;
import za.ac.cput.factory.CustomerOrderFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerOrderServiceTest {
    @Autowired
    private CustomerOrderService orderService;
    CustomerOrder customerOrder;
@BeforeEach
    void setUp() {
    customerOrder = CustomerOrderFactory.buildCustomerOrder("A3456",4,3500.0,"10-01-2024","delivered","12 wrench road","courier","cash");

}
    @Test
    @org.junit.jupiter.api.Order(1)
    void create(){
        CustomerOrder customerOrder1 =orderService.create(customerOrder);
        assertNotNull(customerOrder1);
        System.out.println(customerOrder1);
    }
    @Test
    @org.junit.jupiter.api.Order(2)
    void read(){
        CustomerOrder read= orderService.read(customerOrder.getOrderID());
        assertNotNull(read);
        System.out.println(read);
    }
    @Test
    @org.junit.jupiter.api.Order(3)
    void update(){
        CustomerOrder updateCustomerOrder =new CustomerOrder.Builder().copy(customerOrder).setOrderStatus("pending").build();
        CustomerOrder update=orderService.update(updateCustomerOrder);
        assertNotNull(update);
        System.out.println(update);
    }
    @Test
    @org.junit.jupiter.api.Order(4)
    void getall(){
        System.out.println(orderService.getall());
    }
}

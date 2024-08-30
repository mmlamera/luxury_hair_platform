package za.ac.cput.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderServiceTest {
    @Autowired
    private OrderService orderService;
    Order order;
@BeforeEach
    void setUp() {
    order = OrderFactory.buildOrder("A3456",4,3500.0,"10-01-2024","delivered","12 wrench road","courier","cash");

}
    @Test
    @org.junit.jupiter.api.Order(1)
    void create(){
        Order order1=orderService.create(order);
        assertNotNull(order1);
        System.out.println(order1);
    }
    @Test
    @org.junit.jupiter.api.Order(2)
    void read(){
        Order read= orderService.read(order.getOrderID());
        assertNotNull(read);
        System.out.println(read);
    }
    @Test
    @org.junit.jupiter.api.Order(3)
    void update(){
        Order updateOrder=new Order.Builder().copy(order).setOrderStatus("pending").build();
        Order update=orderService.update(updateOrder);
        assertNotNull(update);
        System.out.println(update);
    }
    @Test
    @org.junit.jupiter.api.Order(4)
    void getall(){
        System.out.println(orderService.getall());
    }
}

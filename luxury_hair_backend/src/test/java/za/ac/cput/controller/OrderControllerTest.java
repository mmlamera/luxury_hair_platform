package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/order";

    private static Order order;


    @BeforeEach
    //@Order(1)
    public void setUp() {
        order= OrderFactory.buildOrder("R2435", 4, 300.0, "20/04/2024", "delivered","12 wrench","courier","cash");
    }

    @Test
   // @Order(2)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Order> postResponse = restTemplate.postForEntity(url, order, Order.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        // assertEquals(postResponse.getStatusCode(), HttpStatus.OK);

      Order orderSaved = postResponse.getBody();
        assertEquals(order.getOrderID(), orderSaved.getOrderID());
        System.out.println("Saved data: " + orderSaved);
    }

    @Test
   // @Order(3)
    void read() {
        String ReviewId = "H3322";
        String url = BASE_URL + "/getall" +ReviewId;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<Order> response = restTemplate.exchange(url, HttpMethod.GET, entity, Order.class);

        System.out.println("Show ALL order : " + order);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }


    @Test
   // @Order(4)
    void update() {
        String url = BASE_URL + "/update";
      Order newOrder = new Order.Builder().copy(order).setOrderStatus("delivered").build();
        ResponseEntity<Order> postResponse = restTemplate.postForEntity(url, newOrder,Order.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

       Order updated = postResponse.getBody();
        assertEquals(newOrder.getOrderID(), updated.getOrderID());
        System.out.println("Updated data: " + updated);
    }

    @Test
   // @Order(5)
    void getall() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }




}

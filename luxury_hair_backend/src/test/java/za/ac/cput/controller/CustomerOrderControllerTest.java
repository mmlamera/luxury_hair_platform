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
import za.ac.cput.domain.CustomerOrder;
import za.ac.cput.factory.CustomerOrderFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerOrderControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/LuxuryHairVendingSystemDB/customerorder";

    private static CustomerOrder customerOrder;


    @BeforeEach
    //@Order(1)
    public void setUp() {
        customerOrder = CustomerOrderFactory.buildCustomerOrder("R2435", 4, 300.0, "20/04/2024", "delivered","12 wrench","courier","cash");
    }

    @Test
   // @Order(2)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<CustomerOrder> postResponse = restTemplate.postForEntity(url, customerOrder, CustomerOrder.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        // assertEquals(postResponse.getStatusCode(), HttpStatus.OK);

      CustomerOrder customerOrderSaved = postResponse.getBody();
        assertEquals(customerOrder.getOrderID(), customerOrderSaved.getOrderID());
        System.out.println("Saved data: " + customerOrderSaved);
    }

    @Test
   // @Order(3)
    void read() {
        String ReviewId = "H3322";
        String url = BASE_URL + "/getall" +ReviewId;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<CustomerOrder> response = restTemplate.exchange(url, HttpMethod.GET, entity, CustomerOrder.class);

        System.out.println("Show ALL order : " + customerOrder);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }


    @Test
   // @Order(4)
    void update() {
        String url = BASE_URL + "/update";
      CustomerOrder newCustomerOrder = new CustomerOrder.Builder().copy(customerOrder).setOrderStatus("delivered").build();
        ResponseEntity<CustomerOrder> postResponse = restTemplate.postForEntity(url, newCustomerOrder, CustomerOrder.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

       CustomerOrder updated = postResponse.getBody();
        assertEquals(newCustomerOrder.getOrderID(), updated.getOrderID());
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

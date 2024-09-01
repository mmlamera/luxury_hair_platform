package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Newsletter;
import za.ac.cput.factory.NewsletterFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NewsletterControllerTest {
@Autowired
private TestRestTemplate trt;
    private String Base_Url = "http://localhost:8080/LuxuryHairVendingSystemDB/newsletter";
private static Newsletter newsletter;
    @BeforeEach
    void setUp() {
        newsletter = NewsletterFactory.createNewsletter(6556L,"johndon@gmail.com");

    }

    @Test
    @Order(1)
    void createUser() {
        String url = Base_Url + "/create";
        ResponseEntity<Newsletter> postResp = trt.postForEntity(url, newsletter, Newsletter.class);
        assertNotNull(postResp);
        assertNotNull(postResp.getBody());
        Newsletter addSaved = postResp.getBody();
        assertEquals(newsletter.getNewsletterId(), addSaved.getNewsletterId());
        System.out.println("Saved data: " + addSaved);

    }

    @Test
    void checkEmailExists() {
    }
}
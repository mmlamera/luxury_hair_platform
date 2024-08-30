package za.ac.cput.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Newsletter;
import za.ac.cput.factory.NewsletterFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NewsletterServiceTest {

    @Autowired
    private NewsletterService service;
    Newsletter newsletter;
    @BeforeEach
    void setUp() {
        newsletter = NewsletterFactory.createNewsletter(1003L, "jakeronald@gmail.com");

    }

    @Test
    @Order(4)
    void getall() {
        System.out.println(service.getall());
    }

    @Test
    @Order(1)
    void create() {
        Newsletter add = service.create(newsletter);
        assertNotNull(add);
        System.out.println("Added : " +  add);
    }

    @Test
    @Order(2)
    void read() {
        Newsletter read = service.read(newsletter.getNewsletterId());
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Newsletter update = new Newsletter.Builder().copy(newsletter).setEmail("theworx@gmail.com").build();
        Newsletter updated = service.update(update);
        System.out.println(updated);
    }
}
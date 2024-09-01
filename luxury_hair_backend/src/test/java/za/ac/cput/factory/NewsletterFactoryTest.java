package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Newsletter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class NewsletterFactoryTest {

    @Test
    void createNewsletter() {
        Newsletter newsletter = NewsletterFactory.createNewsletter(101L,"JohnDoe@gmail.com");
        assertNotNull(newsletter);
        System.out.println(newsletter);
    }
}
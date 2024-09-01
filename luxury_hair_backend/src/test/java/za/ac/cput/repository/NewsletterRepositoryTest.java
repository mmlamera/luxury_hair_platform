package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Newsletter;
import za.ac.cput.factory.NewsletterFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class NewsletterRepositoryTest {
    private Newsletter newsletter;
    @Autowired
    private NewsletterRepository repository;
    @BeforeEach
    void setUp() {
        newsletter = NewsletterFactory.createNewsletter(1221L,"peterpaul@gmail.com");
        assertNotNull(newsletter);
        repository.save(newsletter);
    }

    @Test
    void findByEmail() {
        newsletter = repository.findByEmail("peterpaul@gmail.com");
        System.out.println("Found: " + newsletter);

    }
}
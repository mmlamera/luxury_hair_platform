package za.ac.cput.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Reviews;
import za.ac.cput.factory.ReviewsFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReviewsServiceTest {
    @Autowired
    private ReviewsService reviewsService;
    Reviews reviews;
    @BeforeEach
    void setUp() {
        reviews= ReviewsFactory.buildReviews("R2435", "Love it! Will buy again","The Product is descent", "10-04-2024", 5, "Custom wig Design", "pending","");

    }
    @Test
    @Order(1)
    void create(){
        Reviews reviews1=reviewsService.create(reviews);
        assertNotNull(reviews1);
        System.out.println(reviews1);
    }
    @Test
    @Order(2)
    void read(){
        Reviews read=reviewsService.read(reviews.getReviewId());
        assertNotNull(read);
        System.out.println(read);
    }
    @Test
    @Order(3)
    void update(){
        Reviews updateReviews=new Reviews.Builder().copy(reviews).setServiceName("Closure maintenance").build();
        Reviews update=reviewsService.update(updateReviews);
        assertNotNull(update);
        System.out.println(update);
    }
    @Test
    @Order(4)
    void getall(){
        System.out.println(reviewsService.getall());
    }
}

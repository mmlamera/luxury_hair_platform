package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Reviews;
import za.ac.cput.factory.ReviewsFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ReviewsRepositoryTest {
    @Autowired
    private ReviewsRepository Repository;

    private Reviews reviews;
    @BeforeEach
    void setUp() {
        reviews = ReviewsFactory.buildReviews("R2435", "Love it! Will buy again", "The Product is descent", "10-04-2024", 5, "Custom wig Design", "pending","");
        assertNotNull(reviews);
        System.out.println(reviews);
    }
    @Test
    void findReviewsById(){
        reviews=Repository.findReviewsByReviewId("R2435");
        System.out.println(reviews);

    }
}

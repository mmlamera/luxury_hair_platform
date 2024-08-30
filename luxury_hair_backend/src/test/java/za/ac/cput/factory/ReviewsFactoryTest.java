package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Reviews;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReviewsFactoryTest {
    @Test
    void buildReviews(){
        Reviews reviews= ReviewsFactory.buildReviews("R2435","Love it! Will buy again","The Product is descent","10-04-2024",5,"Custom wig Design","pending","");
        assertNotNull(reviews);
        System.out.println(reviews);
    }
}

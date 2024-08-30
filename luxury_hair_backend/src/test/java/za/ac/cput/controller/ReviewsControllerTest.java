package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Reviews;
import za.ac.cput.factory.ReviewsFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReviewsControllerTest {

        @Autowired
        private TestRestTemplate restTemplate;

        private final String BASE_URL = "http://localhost:8080/reviews";

        private static Reviews reviews;


        @BeforeEach
        @Order(1)
        public void setUp() {
            reviews = ReviewsFactory.buildReviews("R2435", "hair", "Good", "20/04/2024", 5,"custom wig design","submit","");
        }

        @Test
        @Order(2)
        void create() {
            String url = BASE_URL + "/create";
            ResponseEntity<Reviews> postResponse = restTemplate.postForEntity(url, reviews, Reviews.class);
            assertNotNull(postResponse);
            assertNotNull(postResponse.getBody());
            // assertEquals(postResponse.getStatusCode(), HttpStatus.OK);

            Reviews reviewSaved = postResponse.getBody();
            assertEquals(reviews.getReviewId(), reviewSaved.getReviewId());
            System.out.println("Saved data: " + reviewSaved);
        }

        @Test
        @Order(3)
        void read() {
            String ReviewId = "H3322";
            String url = BASE_URL + "/getall" +ReviewId;
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> entity = new HttpEntity<>(null,headers);
            ResponseEntity<Reviews> response = restTemplate.exchange(url, HttpMethod.GET, entity, Reviews.class);

            System.out.println("Show ALL reviews : " + ReviewId);
            assertNotNull(response.getBody());
            System.out.println(response.getBody());
        }


        @Test
        @Order(4)
        void update() {
            String url = BASE_URL + "/update";
            Reviews newReviews = new Reviews.Builder().copy(reviews).setRating(5).build();
            ResponseEntity<Reviews> postResponse = restTemplate.postForEntity(url, newReviews, Reviews.class);
            assertNotNull(postResponse);
            assertNotNull(postResponse.getBody());

            Reviews updated = postResponse.getBody();
            assertEquals(newReviews.getReviewId(), updated.getReviewId());
            System.out.println("Updated data: " + updated);
        }

        @Test
        @Order(5)
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

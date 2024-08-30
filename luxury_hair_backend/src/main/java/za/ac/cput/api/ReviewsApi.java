package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.services.IReviewsService;
import za.ac.cput.services.ReviewsService;

@Component
public class ReviewsApi {
    private  ReviewsService reviewsService;

    private IReviewsService iReviewsService;
    @Autowired
    public ReviewsApi(ReviewsService reviewsService, IReviewsService iReviewsService ) {
        this.reviewsService = reviewsService;
        this.iReviewsService = iReviewsService;
    }


}

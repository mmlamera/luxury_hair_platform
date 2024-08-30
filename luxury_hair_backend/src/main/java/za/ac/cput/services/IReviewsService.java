package za.ac.cput.services;

import za.ac.cput.domain.Reviews;

import java.util.List;

public interface IReviewsService extends IService<Reviews,String>{
    List<Reviews> getall();
}

package com.embarkx.firstjobapp.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReview(Long companyId);
    boolean addReview(Long companyId , Review review);
    Review getReview(long companyId , long reviewId);
    boolean updateReview(long companyId , long reviewId , Review review);
    boolean deleteReview(long companyId , long reviewId);



}

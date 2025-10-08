package com.embarkx.firstjobapp.review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable long companyId){
            return new ResponseEntity<>(reviewService.getAllReview(companyId) ,
                    HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReviews(@PathVariable long companyId,
                           @RequestBody Review review){
        boolean isReviewSaved = reviewService.addReview(companyId , review);
        if(isReviewSaved)
            return new ResponseEntity<>("Review Added Successfully" ,
                    HttpStatus.OK );
        else
            return new ResponseEntity<>("Review Not Saved",
                    HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable long companyId,
                                            @PathVariable long reviewId){
        return new ResponseEntity<>(reviewService.getReview(companyId , reviewId) ,
                                    HttpStatus.OK);
    }

    @PutMapping("/review/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable long companyId,
                                               @PathVariable long reviewId,
                                               @RequestBody Review review){
        boolean isReviewUpdated = reviewService.updateReview(companyId, reviewId, review);
        if(isReviewUpdated){
            return new ResponseEntity<>("review updated successfully" ,
                    HttpStatus.OK);
        }else
            return new ResponseEntity<>("Review Not Updated Successfully",
                    HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable long companyId,
                                               @PathVariable long reviewId ){
        boolean isReviewDeleted = ReviewService.deleteReview(companyId , reviewId);

        if(isReviewDeleted){
            return new ResponseEntity<>("review deleted successfully" ,
                    HttpStatus.OK);
        }else
            return new ResponseEntity<>("Review Not deleted Successfully",
                    HttpStatus.NOT_FOUND);

    }


}

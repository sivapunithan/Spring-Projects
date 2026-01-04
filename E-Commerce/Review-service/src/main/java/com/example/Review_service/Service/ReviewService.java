package com.example.Review_service.Service;

import com.example.Review_service.Entity.Review;
import com.example.Review_service.Repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<Review> getReviewsByProductId(Long productId){
        return reviewRepository.findByProductId(productId);
    }

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public Review createReview(Review review){
        if(review.getRating() < 1 || review.getRating() > 5){
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        return reviewRepository.save(review);
    }
}

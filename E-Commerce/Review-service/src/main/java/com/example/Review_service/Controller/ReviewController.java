package com.example.Review_service.Controller;

import com.example.Review_service.Entity.Review;
import com.example.Review_service.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getReviewsByProductId(@PathVariable Long productId){
        List<Review> reviews = reviewService.getReviewsByProductId(productId);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReview(){
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review){
        Review createReview = reviewService.createReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(createReview);
    }
}

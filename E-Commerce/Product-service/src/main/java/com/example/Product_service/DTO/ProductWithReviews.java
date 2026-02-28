package com.example.Product_service.DTO;

import com.example.Product_service.Entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithReviews {

    private ProductEntity productEntity;
    private List<ReviewDTO> reviews;
    private Integer totalReviews;
    private Double averageRating;

    // Helper method to create average ratings
    public void calculateAverageRating(){
        if(reviews != null && !reviews.isEmpty()){
            this.averageRating = reviews.stream()
                    .mapToInt(ReviewDTO::getRating)
                    .average()
                    .orElse(0.0);
            this.totalReviews = reviews.size();
        } else {
            this.averageRating = 0.0;
            this.totalReviews = 0;
        }
    }
}

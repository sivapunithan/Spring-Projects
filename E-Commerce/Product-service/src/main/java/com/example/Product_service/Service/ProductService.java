package com.example.Product_service.Service;

import com.example.Product_service.Client.ReviewsClient;
import com.example.Product_service.DTO.ProductWithReviews;
import com.example.Product_service.DTO.ReviewDTO;
import com.example.Product_service.Entity.ProductEntity;
import com.example.Product_service.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ReviewsClient client;

    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }

    public ProductWithReviews getProductWithReviews(Long id){
        ProductEntity product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product Not Found"));
        List<ReviewDTO> reviews = client.getReviewsByProductId(id);

        ProductWithReviews productWithReviews = new ProductWithReviews();
        productWithReviews.setProductEntity(product);
        productWithReviews.setReviews(reviews);
        productWithReviews.calculateAverageRating();
        return productWithReviews;
    }

    public ProductEntity createProduct(ProductEntity product){
        return productRepository.save(product);
    }
}

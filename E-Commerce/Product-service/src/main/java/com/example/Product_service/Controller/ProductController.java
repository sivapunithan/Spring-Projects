package com.example.Product_service.Controller;

import com.example.Product_service.DTO.ProductWithReviews;
import com.example.Product_service.Entity.ProductEntity;
import com.example.Product_service.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts(){
        List<ProductEntity> resposne = productService.getAllProducts();
        return ResponseEntity.ok(resposne);
    }

    @GetMapping("/{id}/with-reviews")
    public ResponseEntity<ProductWithReviews> getProductWithReviews(@PathVariable Long id){
        ProductWithReviews response = productService.getProductWithReviews(id);
        return ResponseEntity.ok(response);
    }

//    @GetMapping("/with-reviews")
//    public ResponseEntity<List<ProductWithReviews>> getAllProductWithReviews(){
//        return ResponseEntity.ok(productService.getAllProductWithReviews);
//    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product){
        ProductEntity createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

//    @GetMapping("/category/{category}")
//    public ResponseEntity<List<ProductEntity>> getProductsByCategory(@PathVariable String category){
//        return ResponseEntity.ok(productService.getProductsByCategory());
//    }
}

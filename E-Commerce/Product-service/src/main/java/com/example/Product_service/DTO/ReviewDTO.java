package com.example.Product_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private Long id;
    private Long productId;
    private String userName;
    private String comment;
    private Integer rating;
    private LocalDateTime createdAt;
}

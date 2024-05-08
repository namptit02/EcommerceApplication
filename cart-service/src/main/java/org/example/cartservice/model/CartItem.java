package org.example.cartservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartItem {
    @Id
    private String productId;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
//    private int quantity =1;
    // Thêm các trường khác nếu cần thiết
}

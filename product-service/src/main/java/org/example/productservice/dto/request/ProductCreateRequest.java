package org.example.productservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductCreateRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
}

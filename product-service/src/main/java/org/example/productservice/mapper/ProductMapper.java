package org.example.productservice.mapper;

import org.example.productservice.dto.request.ProductCreateRequest;
import org.example.productservice.dto.request.ProductUpdateRequest;
import org.example.productservice.dto.response.ProductResponse;
import org.example.productservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductCreateRequest request);
    ProductResponse toProductResponse(Product product);
    void updateProduct(@MappingTarget Product product, ProductUpdateRequest request);
}
